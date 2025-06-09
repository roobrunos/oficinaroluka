package com.senai.oficinaroluka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.oficinaroluka.model.OrdemServico;
import com.senai.oficinaroluka.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    public OrdemServico salvar(OrdemServico ordem) {
        return ordemServicoRepository.save(ordem);
    }

    public List<OrdemServico> listarTodas() {
        return ordemServicoRepository.findAll();
    }

    public Optional<OrdemServico> buscarPorId(Long id) {
        return ordemServicoRepository.findById(id);
    }

    public OrdemServico buscarPorCodigo(String codigo) {
        return ordemServicoRepository.findByCodigo(codigo);
    }

    public void deletar(Long id) {
        ordemServicoRepository.deleteById(id);
    }

    public OrdemServico atualizar(Long id, OrdemServico atualizada) {
        OrdemServico ordem = ordemServicoRepository.findById(id).orElseThrow();
        ordem.setStatus(atualizada.getStatus());
        ordem.setCliente(atualizada.getCliente());
        ordem.setVeiculo(atualizada.getVeiculo());
        ordem.setPecas(atualizada.getPecas());
        ordem.setServicos(atualizada.getServicos());
        return ordemServicoRepository.save(ordem);
    }
}

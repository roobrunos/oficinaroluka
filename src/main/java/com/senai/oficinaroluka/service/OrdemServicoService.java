package com.senai.oficinaroluka.service;

import java.time.LocalDate;
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
        if (ordem.getCodigo() == null || ordem.getCodigo().isBlank()) {
            ordem.setCodigo(gerarCodigoUnico());
        }
    
        ordem.setDataCriacao(LocalDate.now());
        return ordemServicoRepository.save(ordem);
    }
    
    private String gerarCodigoUnico() {
        Long ultimaId = ordemServicoRepository.findTopByOrderByIdDesc()
            .map(o -> o.getId() + 1)
            .orElse(1L);
        return String.format("OS%05d", ultimaId);
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

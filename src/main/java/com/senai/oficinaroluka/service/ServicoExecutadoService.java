package com.senai.oficinaroluka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.oficinaroluka.model.ServicoExecutado;
import com.senai.oficinaroluka.repository.ServicoExecutadoRepository;

@Service
public class ServicoExecutadoService {

    @Autowired
    private ServicoExecutadoRepository servicoExecutadoRepository;

    public ServicoExecutado salvar(ServicoExecutado servico) {
        return servicoExecutadoRepository.save(servico);
    }

    public List<ServicoExecutado> listarTodos() {
        return servicoExecutadoRepository.findAll();
    }

    public Optional<ServicoExecutado> buscarPorId(Long id) {
        return servicoExecutadoRepository.findById(id);
    }

    public void deletar(Long id) {
        servicoExecutadoRepository.deleteById(id);
    }

    public ServicoExecutado atualizar(Long id, ServicoExecutado atualizado) {
        ServicoExecutado servico = servicoExecutadoRepository.findById(id).orElseThrow();
        servico.setDescricao(atualizado.getDescricao());
        servico.setProfissional(atualizado.getProfissional());
        servico.setValor(atualizado.getValor());
        return servicoExecutadoRepository.save(servico);
    }
}


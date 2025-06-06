package com.senai.oficinaroluka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.oficinaroluka.model.Peca;
import com.senai.oficinaroluka.repository.PecaRepository;

@Service
public class PecaService {

    @Autowired
    private PecaRepository pecaRepository;

    public Peca salvar(Peca peca) {
        return pecaRepository.save(peca);
    }

    public List<Peca> listarTodas() {
        return pecaRepository.findAll();
    }

    public Optional<Peca> buscarPorId(Long id) {
        return pecaRepository.findById(id);
    }

    public Peca buscarPorCodigo(String codigo) {
        return pecaRepository.findByCodigo(codigo);
    }

    public void deletar(Long id) {
        pecaRepository.deleteById(id);
    }

    public Peca atualizar(Long id, Peca atualizada) {
        Peca peca = pecaRepository.findById(id).orElseThrow();
        peca.setNome(atualizada.getNome());
        peca.setCodigo(atualizada.getCodigo());
        peca.setQuantidadeEstoque(atualizada.getQuantidadeEstoque());
        peca.setPreco(atualizada.getPreco());
        return pecaRepository.save(peca);
    }
}


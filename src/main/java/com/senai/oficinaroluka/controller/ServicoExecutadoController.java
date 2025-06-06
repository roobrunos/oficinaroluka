package com.senai.oficinaroluka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.oficinaroluka.model.ServicoExecutado;
import com.senai.oficinaroluka.service.ServicoExecutadoService;

@RestController
@RequestMapping("/servicos")
public class ServicoExecutadoController {

    @Autowired
    private ServicoExecutadoService servicoExecutadoService;

    @PostMapping
    public ServicoExecutado criar(@RequestBody ServicoExecutado servico) {
        return servicoExecutadoService.salvar(servico);
    }

    @GetMapping
    public List<ServicoExecutado> listar() {
        return servicoExecutadoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ServicoExecutado buscarPorId(@PathVariable Long id) {
        return servicoExecutadoService.buscarPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ServicoExecutado atualizar(@PathVariable Long id, @RequestBody ServicoExecutado servico) {
        return servicoExecutadoService.atualizar(id, servico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        servicoExecutadoService.deletar(id);
    }
}


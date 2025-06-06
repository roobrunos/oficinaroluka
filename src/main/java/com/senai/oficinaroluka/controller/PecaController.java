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

import com.senai.oficinaroluka.model.Peca;
import com.senai.oficinaroluka.service.PecaService;

@RestController
@RequestMapping("/pecas")
public class PecaController {

    @Autowired
    private PecaService pecaService;

    @PostMapping
    public Peca criar(@RequestBody Peca peca) {
        return pecaService.salvar(peca);
    }

    @GetMapping
    public List<Peca> listar() {
        return pecaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Peca buscarPorId(@PathVariable Long id) {
        return pecaService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/codigo/{codigo}")
    public Peca buscarPorCodigo(@PathVariable String codigo) {
        return pecaService.buscarPorCodigo(codigo);
    }

    @PutMapping("/{id}")
    public Peca atualizar(@PathVariable Long id, @RequestBody Peca peca) {
        return pecaService.atualizar(id, peca);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pecaService.deletar(id);
    }
}


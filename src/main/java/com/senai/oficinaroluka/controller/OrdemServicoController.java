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

import com.senai.oficinaroluka.model.OrdemServico;
import com.senai.oficinaroluka.service.OrdemServicoService;

@RestController
@RequestMapping("/ordens")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public OrdemServico criar(@RequestBody OrdemServico ordem) {
        return ordemServicoService.salvar(ordem);
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return ordemServicoService.listarTodas();
    }

    @GetMapping("/{id}")
    public OrdemServico buscarPorId(@PathVariable Long id) {
        return ordemServicoService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/codigo/{codigo}")
    public OrdemServico buscarPorCodigo(@PathVariable String codigo) {
        return ordemServicoService.buscarPorCodigo(codigo);
    }

    @PutMapping("/{id}")
    public OrdemServico atualizar(@PathVariable Long id, @RequestBody OrdemServico ordem) {
        return ordemServicoService.atualizar(id, ordem);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        ordemServicoService.deletar(id);
    }
}


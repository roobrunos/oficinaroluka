package com.senai.oficinaroluka.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.oficinaroluka.model.OrdemServico;
import com.senai.oficinaroluka.repository.OrdemServicoRepository;
import com.senai.oficinaroluka.service.RelatorioPDFService;
import com.senai.oficinaroluka.util.filtro.FiltroExecutor;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private RelatorioPDFService relatorioPDFService;

              // endpoint para filtros personalizados
    @GetMapping("/filtro")
    public List<OrdemServico> buscarComFiltro(@RequestParam String comando) {
        List<OrdemServico> ordens = ordemServicoRepository.findAll();
        return FiltroExecutor.filtrar(ordens, comando);
    }

              // endndpoint para gerar pdf com todas as OSs
    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> gerarPdf() {
        List<OrdemServico> ordens = ordemServicoRepository.findAll();
        ByteArrayInputStream bis = relatorioPDFService.gerarRelatorioOrdens(ordens);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=relatorio-os.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}



package com.senai.oficinaroluka.model;

import jakarta.persistence.*;

@Entity
public class ServicoExecutado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String profissional;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "ordem_id")
    private OrdemServico ordemServico;

    public ServicoExecutado() {}

    public ServicoExecutado(Long id, String descricao, String profissional, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.profissional = profissional;
        this.valor = valor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getProfissional() { return profissional; }
    public void setProfissional(String profissional) { this.profissional = profissional; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public OrdemServico getOrdemServico() { return ordemServico; }
    public void setOrdemServico(OrdemServico ordemServico) { this.ordemServico = ordemServico; }
}


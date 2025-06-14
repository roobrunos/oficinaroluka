package com.senai.oficinaroluka.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;    //  OS 000001
    private String status;     // ABERTA, EM EXECUÇÃO, FINALIZADA
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    @ManyToMany
    @JoinTable(
        name = "ordem_peca",
        joinColumns = @JoinColumn(name = "ordem_id"),
        inverseJoinColumns = @JoinColumn(name = "peca_id")
    )
    private List<Peca> pecas;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
    private List<ServicoExecutado> servicos;

    public OrdemServico() {}

    public OrdemServico(Long id, String codigo, String status, LocalDate dataCriacao) {
        this.id = id;
        this.codigo = codigo;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }

    public List<Peca> getPecas() { return pecas; }
    public void setPecas(List<Peca> pecas) { this.pecas = pecas; }

    public List<ServicoExecutado> getServicos() { return servicos; }
    public void setServicos(List<ServicoExecutado> servicos) { this.servicos = servicos; }
}


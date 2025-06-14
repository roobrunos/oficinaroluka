package com.senai.oficinaroluka.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String documento; // cpf ou cpnj

    private String tipoPessoa; // fisica ou juridica

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    public Cliente() {}

    public Cliente(Long id, String nome, String documento, String tipoPessoa) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.tipoPessoa = tipoPessoa;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getTipoPessoa() { return tipoPessoa; }
    public void setTipoPessoa(String tipoPessoa) { this.tipoPessoa = tipoPessoa; }

    public List<Veiculo> getVeiculos() { return veiculos; }
    public void setVeiculos(List<Veiculo> veiculos) { this.veiculos = veiculos; }
}


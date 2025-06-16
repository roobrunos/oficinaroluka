package com.senai.oficinaroluka.model;

import java.util.List;

import com.senai.oficinaroluka.validation.ValidCPFouCNPJ;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@ValidCPFouCNPJ
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Documento (CPF/CNPJ) é obrigatório")
    private String documento;

    @NotBlank(message = "Tipo de pessoa é obrigatório") // Ex: FISICA ou JURIDICA
    private String tipoPessoa;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    public Cliente() {}
    public Cliente(Long id, String nome, String documento, String tipoPessoa, String telefone) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.tipoPessoa = tipoPessoa;
        this.telefone = telefone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getTipoPessoa() { return tipoPessoa; }
    public void setTipoPessoa(String tipoPessoa) { this.tipoPessoa = tipoPessoa; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public List<Veiculo> getVeiculos() { return veiculos; }
    public void setVeiculos(List<Veiculo> veiculos) { this.veiculos = veiculos; }
}




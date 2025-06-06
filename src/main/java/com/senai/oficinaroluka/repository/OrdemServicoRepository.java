package com.senai.oficinaroluka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.oficinaroluka.model.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    OrdemServico findByCodigo(String codigo); // Exemplo útil
}


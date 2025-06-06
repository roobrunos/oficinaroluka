package com.senai.oficinaroluka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.oficinaroluka.model.ServicoExecutado;

@Repository
public interface ServicoExecutadoRepository extends JpaRepository<ServicoExecutado, Long> {
    // Pode adicionar filtros por profissional, ordem, etc.
}


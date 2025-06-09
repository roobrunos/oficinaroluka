package com.senai.oficinaroluka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.oficinaroluka.model.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Long> {
    Peca findByCodigo(String codigo);   //  busca por código


}


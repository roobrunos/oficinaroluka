package com.senai.oficinaroluka.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.oficinaroluka.model.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    OrdemServico findByCodigo(String codigo); 

    Optional<OrdemServico> findTopByOrderByIdDesc();

}




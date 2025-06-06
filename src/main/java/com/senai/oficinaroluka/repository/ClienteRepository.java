package com.senai.oficinaroluka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.oficinaroluka.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    
    
    // Aqui você pode adicionar métodos customizados se necessário
}


package com.senai.oficinaroluka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.oficinaroluka.model.Cliente;
import com.senai.oficinaroluka.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public Optional<Cliente> buscarPorCpf(String cpf) {
        return clienteRepository.findByDocumento(cpf);
    }
    

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setDocumento(clienteAtualizado.getDocumento());
        cliente.setTipoPessoa(clienteAtualizado.getTipoPessoa());
        return clienteRepository.save(cliente);
    }
}


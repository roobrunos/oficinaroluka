package com.senai.oficinaroluka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.oficinaroluka.model.Veiculo;
import com.senai.oficinaroluka.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo buscarPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }

    public Veiculo atualizar(Long id, Veiculo atualizado) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow();
        veiculo.setPlaca(atualizado.getPlaca());
        veiculo.setModelo(atualizado.getModelo());
        veiculo.setMarca(atualizado.getMarca());
        veiculo.setTipo(atualizado.getTipo());
        veiculo.setCliente(atualizado.getCliente());
        return veiculoRepository.save(veiculo);
    }
}


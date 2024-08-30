package com.example.dbpicpay.service;

import com.example.dbpicpay.models.Cliente;
import com.example.dbpicpay.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }
    public Cliente buscarPorCpf(String cpf) {
        return clienteRepository.findById(cpf).orElseThrow(() -> new RuntimeException("Cliente não encontrado com o CPF: " + cpf));
    }
    @Transactional
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @Transactional
    public Cliente excluirCliente(String cpf) {
        Cliente cliente = buscarPorCpf(cpf);
        clienteRepository.delete(cliente);
        return cliente;
    }
}

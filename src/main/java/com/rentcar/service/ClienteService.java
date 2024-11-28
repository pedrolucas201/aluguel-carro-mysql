package com.rentcar.service;

import com.rentcar.model.Cliente;
import com.rentcar.repository.ClienteRepository;

import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private final ClienteRepository clienteRepository = new ClienteRepository();

    public void cadastrarCliente(Cliente cliente) throws SQLException {
        clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() throws SQLException {
        return clienteRepository.findAll();
    }
}

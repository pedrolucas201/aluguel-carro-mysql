package com.rentcar.repository;

import com.rentcar.config.DatabaseConnection;
import com.rentcar.model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public void save(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (Nome, CPF, Telefone, Rua, Numero, Cidade, Estado, CEP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getRua());
            stmt.setInt(5, cliente.getNumero());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getEstado());
            stmt.setString(8, cliente.getCep());
            stmt.executeUpdate();
        }
    }

    public List<Cliente> findAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("ID_Cliente"));
                cliente.setNome(rs.getString("Nome"));
                cliente.setCpf(rs.getString("CPF"));
                cliente.setTelefone(rs.getString("Telefone"));
                cliente.setRua(rs.getString("Rua"));
                cliente.setNumero(rs.getInt("Numero"));
                cliente.setCidade(rs.getString("Cidade"));
                cliente.setEstado(rs.getString("Estado"));
                cliente.setCep(rs.getString("CEP"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}

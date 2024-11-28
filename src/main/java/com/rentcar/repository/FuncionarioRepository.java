package com.rentcar.repository;

import com.rentcar.config.DatabaseConnection;
import com.rentcar.model.Funcionario;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {

    public void save(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO Funcionario (Nome, CPF, Cargo, Salario) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getCargo());
            stmt.setBigDecimal(4, funcionario.getSalario());
            stmt.executeUpdate();
        }
    }

    public List<Funcionario> findAll() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("ID_Funcionario"));
                funcionario.setNome(rs.getString("Nome"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setCargo(rs.getString("Cargo"));
                funcionario.setSalario(rs.getBigDecimal("Salario"));
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }
}

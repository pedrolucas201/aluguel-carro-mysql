package com.rentcar.repository;

import com.rentcar.config.DatabaseConnection;
import com.rentcar.model.CategoriaVeiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaVeiculoRepository {

    public void save(CategoriaVeiculo categoriaVeiculo) throws SQLException {
        String sql = "INSERT INTO Categoria_Veiculo (Nome_Categoria) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoriaVeiculo.getNomeCategoria());
            stmt.executeUpdate();
        }
    }

    public List<CategoriaVeiculo> findAll() throws SQLException {
        List<CategoriaVeiculo> categorias = new ArrayList<>();
        String sql = "SELECT * FROM Categoria_Veiculo";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CategoriaVeiculo categoria = new CategoriaVeiculo();
                categoria.setId(rs.getInt("ID_Categoria"));
                categoria.setNomeCategoria(rs.getString("Nome_Categoria"));
                categorias.add(categoria);
            }
        }
        return categorias;
    }
}

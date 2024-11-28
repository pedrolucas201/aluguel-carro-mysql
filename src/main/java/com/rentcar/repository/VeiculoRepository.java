package com.rentcar.repository;

import com.rentcar.config.DatabaseConnection;
import com.rentcar.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository {

    public void save(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO Veiculo (Placa, Marca, Modelo, Ano_Fabricacao, Quilometragem, ID_Categoria) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, veiculo.getPlaca());
            stmt.setString(2, veiculo.getMarca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setInt(4, veiculo.getAnoFabricacao());
            stmt.setInt(5, veiculo.getQuilometragem());
            stmt.setInt(6, veiculo.getIdCategoria());
            stmt.executeUpdate();
        }
    }

    public List<Veiculo> findAll() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM Veiculo";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getInt("ID_Veiculo"));
                veiculo.setPlaca(rs.getString("Placa"));
                veiculo.setMarca(rs.getString("Marca"));
                veiculo.setModelo(rs.getString("Modelo"));
                veiculo.setAnoFabricacao(rs.getInt("Ano_Fabricacao"));
                veiculo.setQuilometragem(rs.getInt("Quilometragem"));
                veiculo.setIdCategoria(rs.getInt("ID_Categoria"));
                veiculos.add(veiculo);
            }
        }
        System.out.println("Veículos encontrados no banco: " + veiculos.size());
        return veiculos;
    }

    public boolean categoriaExiste(int idCategoria) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Categoria_Veiculo WHERE ID_Categoria = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }


}

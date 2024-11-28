package com.rentcar.repository;

import com.rentcar.config.DatabaseConnection;
import com.rentcar.model.Manutencao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManutencaoRepository {

    public void save(Manutencao manutencao) throws SQLException {
        String sql = "INSERT INTO Manutencao (Data, ID_Veiculo) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(manutencao.getData()));
            stmt.setInt(2, manutencao.getIdVeiculo());
            stmt.executeUpdate();
        }
    }

    public List<Manutencao> findAll() throws SQLException {
        List<Manutencao> manutencoes = new ArrayList<>();
        String sql = "SELECT * FROM Manutencao";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Manutencao manutencao = new Manutencao();
                manutencao.setId(rs.getInt("ID_Manutencao"));
                manutencao.setData(rs.getDate("Data").toLocalDate());
                manutencao.setIdVeiculo(rs.getInt("ID_Veiculo"));
                manutencoes.add(manutencao);
            }
        }
        return manutencoes;
    }
}

package com.rentcar.repository;

import com.rentcar.config.DatabaseConnection;
import com.rentcar.model.Aluguel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AluguelRepository {

    public void save(Aluguel aluguel) throws SQLException {
        String sql = "INSERT INTO Aluguel (Data_Inicio, Data_Termino, Valor_Total, ID_Cliente, ID_Funcionario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(aluguel.getDataInicio()));
            stmt.setDate(2, Date.valueOf(aluguel.getDataTermino()));
            stmt.setBigDecimal(3, aluguel.getValorTotal());
            stmt.setInt(4, aluguel.getIdCliente());
            stmt.setInt(5, aluguel.getIdFuncionario());
            stmt.executeUpdate();
        }
    }

    public List<Aluguel> findAll() throws SQLException {
        List<Aluguel> alugueis = new ArrayList<>();
        String sql = "SELECT * FROM Aluguel";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluguel aluguel = new Aluguel();
                aluguel.setId(rs.getInt("ID_Aluguel"));
                aluguel.setDataInicio(rs.getDate("Data_Inicio").toLocalDate());
                aluguel.setDataTermino(rs.getDate("Data_Termino").toLocalDate());
                aluguel.setValorTotal(rs.getBigDecimal("Valor_Total"));
                aluguel.setIdCliente(rs.getInt("ID_Cliente"));
                aluguel.setIdFuncionario(rs.getInt("ID_Funcionario"));
                alugueis.add(aluguel);
            }
        }
        return alugueis;
    }
}

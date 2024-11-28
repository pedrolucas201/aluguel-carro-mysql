package com.rentcar.service;

import com.rentcar.model.Manutencao;
import com.rentcar.repository.ManutencaoRepository;

import java.sql.SQLException;
import java.util.List;

public class ManutencaoService {
    private final ManutencaoRepository manutencaoRepository = new ManutencaoRepository();

    public void cadastrarManutencao(Manutencao manutencao) throws SQLException {
        manutencaoRepository.save(manutencao);
    }

    public List<Manutencao> listarManutencoes() throws SQLException {
        return manutencaoRepository.findAll();
    }
}

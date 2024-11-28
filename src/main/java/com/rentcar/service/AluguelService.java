package com.rentcar.service;

import com.rentcar.model.Aluguel;
import com.rentcar.repository.AluguelRepository;

import java.sql.SQLException;
import java.util.List;

public class AluguelService {
    private final AluguelRepository aluguelRepository = new AluguelRepository();

    public void cadastrarAluguel(Aluguel aluguel) throws SQLException {
        aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarAlugueis() throws SQLException {
        return aluguelRepository.findAll();
    }
}

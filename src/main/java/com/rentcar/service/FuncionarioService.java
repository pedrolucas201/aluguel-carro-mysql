package com.rentcar.service;

import com.rentcar.model.Funcionario;
import com.rentcar.repository.FuncionarioRepository;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() throws SQLException {
        return funcionarioRepository.findAll();
    }
}

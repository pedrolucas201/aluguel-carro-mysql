package com.rentcar.service;

import com.rentcar.model.CategoriaVeiculo;
import com.rentcar.repository.CategoriaVeiculoRepository;

import java.sql.SQLException;
import java.util.List;

public class CategoriaVeiculoService {
    private final CategoriaVeiculoRepository categoriaVeiculoRepository = new CategoriaVeiculoRepository();

    public void cadastrarCategoria(CategoriaVeiculo categoria) throws SQLException {
        categoriaVeiculoRepository.save(categoria);
    }

    public List<CategoriaVeiculo> listarCategorias() throws SQLException {
        return categoriaVeiculoRepository.findAll();
    }
}

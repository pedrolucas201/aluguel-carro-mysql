package com.rentcar.service;

import com.rentcar.model.Veiculo;
import com.rentcar.repository.VeiculoRepository;

import java.sql.SQLException;
import java.util.List;

public class VeiculoService {
    private final VeiculoRepository veiculoRepository = new VeiculoRepository();

    public void cadastrarVeiculo(Veiculo veiculo) throws SQLException {
        System.out.println("Verificando se a categoria existe: " + veiculo.getIdCategoria());
        if (!veiculoRepository.categoriaExiste(veiculo.getIdCategoria())) {
            throw new IllegalArgumentException("Categoria não encontrada: ID " + veiculo.getIdCategoria());
        }
        System.out.println("Salvando veículo: " + veiculo.getPlaca());
        veiculoRepository.save(veiculo);
        System.out.println("Veículo salvo com sucesso.");
    }


    public List<Veiculo> listarVeiculos() throws SQLException {
        System.out.println("Serviço: listando veículos...");
        List<Veiculo> veiculos = veiculoRepository.findAll();
        System.out.println("Serviço: " + veiculos.size() + " veículos encontrados.");
        return veiculos;
    }




}

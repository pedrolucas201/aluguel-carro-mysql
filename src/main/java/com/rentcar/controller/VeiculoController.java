package com.rentcar.controller;

import com.rentcar.model.Veiculo;
import com.rentcar.service.VeiculoService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class VeiculoController {

    @FXML
    private TextField placaField;

    @FXML
    private TextField marcaField;

    @FXML
    private TextField modeloField;

    @FXML
    private TextField anoField;

    @FXML
    private TextField quilometragemField;

    @FXML
    private TextField categoriaField;

    @FXML
    private TableView<Veiculo> veiculoTable;

    @FXML
    private TableColumn<Veiculo, Integer> idColumn;

    @FXML
    private TableColumn<Veiculo, String> placaColumn;

    @FXML
    private TableColumn<Veiculo, String> marcaColumn;

    @FXML
    private TableColumn<Veiculo, String> modeloColumn;


    private final VeiculoService veiculoService = new VeiculoService(); // Instância do serviço

    @FXML
    public void initialize() {
        System.out.println("Inicializando controlador de Veículos...");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        placaColumn.setCellValueFactory(new PropertyValueFactory<>("placa"));
        marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloColumn.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        atualizarTabela(); // Chama o serviço para listar os veículos
    }

    private void atualizarTabela() {
        try {
            System.out.println("Atualizando tabela de veículos...");
            veiculoTable.getItems().setAll(veiculoService.listarVeiculos());
            System.out.println("Tabela atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void handleSalvarVeiculo() {
        try {
            Veiculo veiculo = new Veiculo();
            veiculo.setPlaca(placaField.getText());
            veiculo.setMarca(marcaField.getText());
            veiculo.setModelo(modeloField.getText());
            veiculo.setAnoFabricacao(Integer.parseInt(anoField.getText()));
            veiculo.setQuilometragem(Integer.parseInt(quilometragemField.getText()));
            veiculo.setIdCategoria(Integer.parseInt(categoriaField.getText()));

            veiculoService.cadastrarVeiculo(veiculo);
            atualizarTabela();
            System.out.println("Veículo salvo com sucesso!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            // Exiba um alerta para o usuário
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

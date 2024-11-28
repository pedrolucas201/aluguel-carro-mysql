package com.rentcar.controller;

import com.rentcar.model.CategoriaVeiculo;
import com.rentcar.service.CategoriaVeiculoService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CategoriaVeiculoController {

    @FXML
    private TextField nomeCategoriaField;

    @FXML
    private TableView<CategoriaVeiculo> categoriaTable;

    private final CategoriaVeiculoService categoriaService = new CategoriaVeiculoService();

    @FXML
    public void handleSalvarCategoria() {
        CategoriaVeiculo categoria = new CategoriaVeiculo();
        categoria.setNomeCategoria(nomeCategoriaField.getText());
        try {
            categoriaService.cadastrarCategoria(categoria);
            atualizarTabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizarTabela() {
        try {
            categoriaTable.getItems().setAll(categoriaService.listarCategorias());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

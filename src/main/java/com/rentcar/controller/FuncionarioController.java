package com.rentcar.controller;

import com.rentcar.model.Funcionario;
import com.rentcar.service.FuncionarioService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.math.BigDecimal;

public class FuncionarioController {

    @FXML
    private TextField nomeField, cpfField, cargoField, salarioField;

    @FXML
    private TableView<Funcionario> funcionarioTable;

    private final FuncionarioService funcionarioService = new FuncionarioService();

    @FXML
    public void handleSalvarFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nomeField.getText());
        funcionario.setCpf(cpfField.getText());
        funcionario.setCargo(cargoField.getText());
        funcionario.setSalario(new BigDecimal(salarioField.getText()));
        try {
            funcionarioService.cadastrarFuncionario(funcionario);
            atualizarTabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizarTabela() {
        try {
            funcionarioTable.getItems().setAll(funcionarioService.listarFuncionarios());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

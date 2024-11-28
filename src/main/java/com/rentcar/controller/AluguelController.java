package com.rentcar.controller;

import com.rentcar.model.Aluguel;
import com.rentcar.service.AluguelService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AluguelController {

    @FXML
    private TextField dataInicioField, dataTerminoField, valorTotalField, idClienteField, idFuncionarioField;

    @FXML
    private TableView<Aluguel> aluguelTable;

    private final AluguelService aluguelService = new AluguelService();

    @FXML
    public void handleSalvarAluguel() {
        Aluguel aluguel = new Aluguel();
        aluguel.setDataInicio(LocalDate.parse(dataInicioField.getText()));
        aluguel.setDataTermino(LocalDate.parse(dataTerminoField.getText()));
        aluguel.setValorTotal(new BigDecimal(valorTotalField.getText()));
        aluguel.setIdCliente(Integer.parseInt(idClienteField.getText()));
        aluguel.setIdFuncionario(Integer.parseInt(idFuncionarioField.getText()));
        try {
            aluguelService.cadastrarAluguel(aluguel);
            atualizarTabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizarTabela() {
        try {
            aluguelTable.getItems().setAll(aluguelService.listarAlugueis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

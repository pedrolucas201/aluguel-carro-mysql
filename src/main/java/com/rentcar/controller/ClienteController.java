package com.rentcar.controller;

import com.rentcar.model.Cliente;
import com.rentcar.service.ClienteService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClienteController {

    @FXML
    private TextField nomeField;
    @FXML
    private TextField cpfField;
    @FXML
    private TableView<Cliente> clienteTable;

    private final ClienteService clienteService = new ClienteService();

    @FXML
    public void handleSalvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(nomeField.getText());
        cliente.setCpf(cpfField.getText());
        try {
            clienteService.cadastrarCliente(cliente);
            atualizarTabela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void atualizarTabela() {
        try {
            clienteTable.getItems().setAll(clienteService.listarClientes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

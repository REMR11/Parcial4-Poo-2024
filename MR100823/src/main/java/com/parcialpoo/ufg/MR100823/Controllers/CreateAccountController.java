package com.parcialpoo.ufg.MR100823.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.Costumer;
import com.parcialpoo.ufg.MR100823.services.Costumer.CostumerService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Component
public class CreateAccountController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField PhoneField;

    @Autowired
    private CostumerService costumerService; // Initialize CostumerService properly using dependency injection

    @FXML
    private void handleCreateAccountButtonClick(ActionEvent event) {
        // Crear una nueva cuenta con los datos ingresados
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String phone = PhoneField.getText();
        int phonenumber;
        try {
            phonenumber = Integer.parseInt(phone);
        } catch (NumberFormatException e) {
            // Handle the NumberFormatException here
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en el formato del número de teléfono");
            alert.setContentText("Por favor, ingrese un número de teléfono válido");
            alert.showAndWait();
            return;
        }

        // Llamar al servicio de creación de cuenta
        costumerService.saveCostumer(new Costumer(name, email, password, phonenumber));

        // Mostrar un mensaje de éxito
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cuenta creada");
        alert.setHeaderText("La cuenta ha sido creada con éxito");
        alert.setContentText("Puedes iniciar sesión con tu nueva cuenta");
        alert.showAndWait();
    }
}
package com.parcialpoo.ufg.MR100823.Controllers;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.services.Costumer.CostumerService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controlador de la vista de inicio de sesión.
 */
@Component
public class ViewLoginController {
    /**
     * Servicio de autenticación de clientes inyectado.
     */
    private CostumerService pCostumerService = new CostumerService();

    /**
     * Campo de texto para el nombre de usuario.
     */
    @FXML
    private TextField usernameField;

    /**
     * Campo de texto para la contraseña.
     */
    @FXML
    private PasswordField passwordField;

    /**
     * Manejador del evento de clic en el botón de inicio de sesión.
     * 
     * @param event evento de clic en el botón de inicio de sesión
     */
    @FXML
    private void handleLoginButtonClick(ActionEvent event) {
        String pEmail = usernameField.getText();
        String password = passwordField.getText();

        try {
            /**
             * Autenticar las credenciales del usuario utilizando el servicio de autenticación.
             */
            boolean isValid = pCostumerService.login(pEmail, password);

            if (isValid) {
                /**
                 * Si las credenciales son válidas, cerrar la ventana de inicio de sesión y mostrar la ventana principal.
                 */
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.close();

                /**
                 * Mostrar la ventana principal.
                 */
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/templates/index.fxml"));
                Parent root = loader.load();
                Stage mainStage = new Stage();
                mainStage.setScene(new Scene(root));
                mainStage.show();
            } else {
                /**
                 * Si las credenciales son inválidas, mostrar un mensaje de error al usuario.
                 */
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de inicio de sesión");
                alert.setHeaderText("Las credenciales son inválidas");
                alert.setContentText("Por favor, verifique su nombre de usuario y contraseña e inténtelo de nuevo.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            /**
             * Manejar cualquier excepción que se produzca durante el proceso de inicio de sesión.
             */
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de inicio de sesión");
            alert.setHeaderText("Error desconocido");
            alert.setContentText(
                    "Ocurrió un error desconocido durante el proceso de inicio de sesión. Por favor, inténtelo de nuevo más tarde.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCreateAccountButtonClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/templates/createAccount.fxml"));
        Parent root = loader.load();
        Stage createAccountStage = new Stage();
        createAccountStage.setScene(new Scene(root));
        createAccountStage.show();
    }
}
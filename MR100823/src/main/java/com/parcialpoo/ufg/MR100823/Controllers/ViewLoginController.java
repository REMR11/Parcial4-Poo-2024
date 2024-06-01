package com.parcialpoo.ufg.MR100823.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

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
public class ViewLoginController {
    /**
     * Servicio de autenticación de clientes inyectado.
     */
    @Autowired
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
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            /**
             * Autenticar las credenciales del usuario utilizando el servicio de autenticación.
             */
            boolean isValid = pCostumerService.login(username, password);

            if (isValid) {
                /**
                 * Si las credenciales son válidas, cerrar la ventana de inicio de sesión y mostrar la ventana principal.
                 */
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.close();

                /**
                 * Mostrar la ventana principal.
                 */
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
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
}
package com.parcialpoo.ufg.MR100823.Presentation;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.parcialpoo.ufg.MR100823.Mr100823Application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación de reservaciones, responsable de inicializar
 * y mostrar la interfaz de usuario.
 * 
 * @author remr1
 */
public class SistemaReservaciones extends Application {

	/**
	 * Contexto de aplicación configurable, utilizado para acceder a los beans de la
	 * aplicación.
	 */
	private ConfigurableApplicationContext applicationContext;

	/**
	 * Método de inicialización de la aplicación, llamado antes de que se inicie la
	 * aplicación.
	 * 
	 * Inicializa el contexto de aplicación con la configuración de la aplicación
	 * principal.
	 */
	@Override
	public void init() {
		this.applicationContext = new SpringApplicationBuilder(Mr100823Application.class).run();
	}

	/**
	 * Método principal de la aplicación, llamado cuando se inicia la aplicación.
	 * 
	 * Carga la interfaz de usuario desde el archivo FXML y la muestra en la escena
	 * principal.
	 * 
	 * @param stage Escena principal de la aplicación.
	 * @throws Exception Si ocurre un error al cargar la interfaz de usuario.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		// Crea un cargador de FXML para cargar la interfaz de usuario desde el archivo
		// index.fxml
		FXMLLoader louder = new FXMLLoader(Mr100823Application.class.getResource("/templates/index.fxml"));

		// Establece la fábrica de controladores para que utilice los beans de la
		// aplicación
		louder.setControllerFactory(applicationContext::getBean);

		// Carga la interfaz de usuario desde el archivo FXML
		Scene escena = new Scene(louder.load());

		// Establece la escena principal de la aplicación
		stage.setScene(escena);

		// Muestra la escena principal de la aplicación
		stage.show();
	}
	
	/**
	 * Método que se llamara al finalizar el programa
	 * */
	@Override
	public void stop() {
		// Cerramos la fabrica de spring, con esto nos aseguramos que cualquier conexion con la base de datos
		applicationContext.close();
		// Finalizamos la ejecucion de la aplicacion de JavaFX
		Platform.exit();
	}
}
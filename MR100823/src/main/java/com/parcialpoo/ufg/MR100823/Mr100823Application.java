package com.parcialpoo.ufg.MR100823;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parcialpoo.ufg.MR100823.Presentation.SistemaReservaciones;

import javafx.application.Application;

@SpringBootApplication
public class Mr100823Application {

	public static void main(String[] args) {
		//SpringApplication.run(Mr100823Application.class, args);
		Application.launch(SistemaReservaciones.class);
	}

}

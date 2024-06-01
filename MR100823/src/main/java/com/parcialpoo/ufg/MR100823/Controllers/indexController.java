package com.parcialpoo.ufg.MR100823.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parcialpoo.ufg.MR100823.models.FoodPlate;
import com.parcialpoo.ufg.MR100823.services.FoodPlate.FoodPlateService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import org.slf4j.*;

@Component
public class indexController implements Initializable{

	private static final Logger logger= LoggerFactory.getLogger(indexController.class);
	
	@Autowired
	private FoodPlateService foodPlateService;
	
	@FXML
	private TableView<FoodPlate> plate;
	
	@FXML
	private TableColumn<FoodPlate, Integer>foodPlate_id;
	
	@FXML
	private TableColumn<FoodPlate, String>NameColumn;

	@FXML
	private TableColumn<FoodPlate, String>DescriptionColumn;
	
	@FXML
	private TableColumn<FoodPlate, Float>PriceColumn;
	
	private final ObservableList<FoodPlate> platilloLista = FXCollections.observableArrayList();
	
	@FXML
	private TextField nombreTexto;
	
	@FXML
	private TextField descripcionTexto;
	
	@FXML
	private TextField precioTexto;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		plate.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		configurtionColum();
		listFoodPlates();
	}
	
	public void configurtionColum() {
		foodPlate_id.setCellValueFactory(new PropertyValueFactory<>("foodPlate_id"));
		NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
		PriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
	} 
	
	public void listFoodPlates() {
		logger.info("Ejecutanto listado de platos");
		platilloLista.clear();
		platilloLista.addAll(foodPlateService.showAll());
		plate.setItems(platilloLista);
	}

	public void foodPlateAdd() {
		if(nombreTexto.getText().isEmpty()) {
			showMessage("Error de validacion", "Debe proporcionar un platillo");
			nombreTexto.requestFocus();
			return;
		}else {
			var plate = new FoodPlate();
			collectFormData(plate);
			
			foodPlateService.saveFoodPlate(plate);
			showMessage("Informacion", "Tarea agregada");
			cleanForm();
			listFoodPlates();
		}
		
	}
	
	public void collectFormData(FoodPlate pFoodPlate) {
		pFoodPlate.setName(nombreTexto.getText());
		pFoodPlate.setDescription(descripcionTexto.getText());
		String texto = precioTexto.getText();
		pFoodPlate.setPrice(Float.parseFloat(texto));
	}
	
	private void cleanForm() {
		nombreTexto.clear();
		descripcionTexto.clear();
		precioTexto.clear();
	}
	public void showMessage(String pType, String pMenssage ) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(pType);
		alert.setHeaderText(null);
		alert.setContentText(pMenssage);
		alert.showAndWait();
	}
}

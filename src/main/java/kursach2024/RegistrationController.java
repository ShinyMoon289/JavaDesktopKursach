package kursach2024;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistrationController {
	@FXML
	private TextField nameField;
	@FXML
	private TextField lastNameField;

	@FXML
	public void onCloseRegistration(ActionEvent event){
		final Node source = (Node)event.getSource();
		final Stage stage = (Stage)source.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void onSendRegistration(ActionEvent event){

	}

}

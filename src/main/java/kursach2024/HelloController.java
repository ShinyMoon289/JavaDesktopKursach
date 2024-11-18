package kursach2024;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
	@FXML
	private Label welcomeText;

	@FXML
	private Button loginButton;
	@FXML
	private Button regButton;

	@FXML
	public void startLoginWindow(ActionEvent event){
		System.out.println("Прикол");
	}


	@FXML
	public void startRegistrationScreen(ActionEvent event)throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Windows/UserRegistration/userRegistration.fxml"));
		Stage stage = new Stage();
		Scene regScene = new Scene(fxmlLoader.load());
		stage.setScene(regScene);

		stage.setTitle("reg");
		stage.show();
	}

	@FXML
	public void onExit(ActionEvent event){
		Platform.exit();
	}

}
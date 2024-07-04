package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class sceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToPatient(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Patientlogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToDoctorNurse(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("DoctorNurselogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToAccountCreate(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AccountCreate.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
}

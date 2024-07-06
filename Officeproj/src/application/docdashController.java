package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class docdashController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void switchToRolePicker(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Rolepicker.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToDocMessages(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("DocMessages.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToPatientLookup(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Lookup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToAddPatient(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EditLookup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
}
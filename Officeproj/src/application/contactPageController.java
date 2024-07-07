package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class contactPageController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TextField phone;
	@FXML
	private TextField email;
	@FXML
	private TextField homeaddress;
	@FXML
	private TextField pharma;
	
	
	
	public void switchToViewContact(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("contactinfoview.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
}
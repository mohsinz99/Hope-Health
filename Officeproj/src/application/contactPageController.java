package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Label message;
	@FXML
	private Label firstlabel;
	@FXML
	private Label lastlabel;
	@FXML
	private Label phonelabel;
	@FXML
	private Label emaillabel;
	@FXML
	private Label homelabel;
	@FXML
	private Label pharmalabel;
	
	
	public void saveContact(ActionEvent event) {
	    String newContactInfo = String.join(",", 
	        firstname.getText(), 
	        lastname.getText(), 
	        phone.getText(), 
	        email.getText(), 
	        homeaddress.getText(), 
	        pharma.getText(),
	        username.getText(),
	        password.getText());

	    File file = new File("src/application/contacts.txt");
	    List<String> lines = new ArrayList<>();
	    boolean found = false;

	    // Read existing file
	    try {
	        if (file.exists()) {
	            lines = Files.readAllLines(file.toPath());
	            for (int i = 0; i < lines.size(); i++) {
	                String line = lines.get(i);
	                String[] parts = line.split(",");
	                if (parts.length == 8 && parts[6].equals(username.getText()) && parts[7].equals(password.getText())) {
	                    // Update existing record
	                    lines.set(i, newContactInfo);
	                    found = true;
	                    break;
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	 // Check if all fields are not empty
	    if (!firstname.getText().isEmpty() && !lastname.getText().isEmpty() && 
	        !phone.getText().isEmpty() && !email.getText().isEmpty() && 
	        !homeaddress.getText().isEmpty() && !pharma.getText().isEmpty() && 
	        !username.getText().isEmpty() && !password.getText().isEmpty()) {
	        
	        if (!found) {
	            lines.add(newContactInfo);
	        }

	        // Write updated list to file
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	            for (String line : lines) {
	                writer.write(line);
	                writer.newLine();
	            }
	            message.setText("Data saved successfully");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        message.setText("All Data fields must be filled before saving");
	    }
	}
	
	
	
	public void switchToViewContact(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("contactinfoview.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToContactEdit(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EditContactInformation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void displayInfo(ActionEvent event) throws IOException {
		File file = new File("src/application/contacts.txt");
	    try {
	        if (file.exists()) {
	            List<String> lines = Files.readAllLines(file.toPath());
	            for (String line : lines) {
	                String[] parts = line.split(",");
	                if (parts.length == 8 && parts[6].equals(username.getText()) && parts[7].equals(password.getText())) {
	                    firstlabel.setText(parts[0]);
	                    lastlabel.setText(parts[1]);
	                    phonelabel.setText(parts[2]);
	                    emaillabel.setText(parts[3]);
	                    homelabel.setText(parts[4]);
	                    pharmalabel.setText(parts[5]);
	                    return;
	                }
	            }
	            message.setText("No contact information found for the provided username and password.");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
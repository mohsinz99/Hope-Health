package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class sceneController {
	
	@FXML
	private TextField usernameField;
	@FXML
	private TextField passwordField;
	
	@FXML
	private TextField usernameField1;
	@FXML
	private TextField passwordField1;
	
	@FXML
	private TextField usernameinput;
	@FXML
	private TextField passwordinput;
	
	@FXML
	private Label message;
	
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
	
	public void switchToVisits(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("VisitSummary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToPatientMessages(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("PatientMessages.fxml"));
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
	
	public void switchToViewMyRecords(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("PatientViewRecords.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToRolePicker(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Rolepicker.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToPatientDashboard(ActionEvent event) throws IOException {
		String username = usernameField.getText();
        String password = passwordField.getText();
        if (validateCredentialsPatient(username, password)) {
            Parent root = FXMLLoader.load(getClass().getResource("PatientDash.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            message.setText("Invalid credentials. Please try again");
        }
    }
	
	public void switchToDoctorDashboard(ActionEvent event) throws IOException {
		String username = usernameField1.getText();
        String password = passwordField1.getText();
        if (validateCredentialsDoctor(username, password)) {
            Parent root = FXMLLoader.load(getClass().getResource("DoctorDash.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
        	message.setText("Invalid credentials. Please try again");
        }
    }
	
	private boolean validateCredentialsPatient(String username, String password) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/application/credentials.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String fileUsername = parts[0];
                    String filePassword = parts[1];
                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	private boolean validateCredentialsDoctor(String username, String password) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/application/credentialsDoc.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String fileUsername = parts[0];
                    String filePassword = parts[1];
                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public void createAccount(ActionEvent event) {
        String usernamein = usernameinput.getText();
        String passwordin = passwordinput.getText();
        if (usernamein.isEmpty() || passwordin.isEmpty()) {
            message.setText("Username/Password fields cannot be empty");
            return;
        }
        if (validateCredentialsPatient(usernamein,passwordin)) {
        	message.setText("Account already exists");
        	return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/application/credentials.txt", true))) {
            bw.write(usernamein + ":" + passwordin);
            bw.newLine();
            message.setText("Account created successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

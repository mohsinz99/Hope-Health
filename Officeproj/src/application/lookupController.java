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
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import javafx.scene.control.Label;

public class lookupController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TextField gender;
	@FXML
	private TextField birthday;
	@FXML
	private TextField weight;
	@FXML
	private TextField height;
	@FXML
	private TextField concerns;
	@FXML
	private TextField temp;
	@FXML
	private TextField issues;
	@FXML
	private TextField medications;
	@FXML
	private TextField immunizations;
	@FXML
	private TextField systolic;
	@FXML
	private TextField diastolic;
	@FXML
	private TextField firstnameE;
	@FXML
	private TextField lastnameE;
	@FXML
    Label error = new Label("Enter a Patient");

	
	public void switchToDoctorDash(ActionEvent event) throws IOException {
		firstname.clear();
		lastname.clear();
		gender.clear();
		birthday.clear();
		weight.clear();
		height.clear();
		concerns.clear();
		temp.clear();
		issues.clear();
		medications.clear();
		immunizations.clear();
		systolic.clear();
		diastolic.clear();
		firstnameE.clear();
		lastnameE.clear();
		
		Parent root = FXMLLoader.load(getClass().getResource("DoctorDash.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
	}
	
	public void switchToViewEditRecords(ActionEvent event) throws IOException {
		if(recieve())
		{
		Parent root = FXMLLoader.load(getClass().getResource("EditLookup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
		}
	}
	
	public void save(ActionEvent event) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(firstnameE + "_" + lastnameE))) 
		{
    		writer.write(firstname.getText());
    		writer.write(lastname.getText());
    		writer.write(gender.getText());
    		writer.write(birthday.getText());
    		writer.write(weight.getText());
    		writer.write(height.getText());
    		writer.write(concerns.getText());
    		writer.write(temp.getText());
    		writer.write(issues.getText());
    		writer.write(medications.getText());
    		writer.write(immunizations.getText());
    		writer.write(systolic.getText());
    		writer.write(diastolic.getText());
        }			
		
		catch (IOException e) 
		{
            e.printStackTrace();
        }
	}
	
	public boolean recieve() {	    
		File dir = new File(System.getProperty("src/application"));
		File[] fileList = dir.listFiles();
        for (File file : fileList) 
        {
            if (file.isFile() && file.getName().equals(firstnameE.getText() + "_" + lastnameE.getText())) 
            {
            	try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
            		firstname.setText(reader.readLine());
            		lastname.setText(reader.readLine());
            		gender.setText(reader.readLine());
            		birthday.setText(reader.readLine());
            		weight.setText(reader.readLine());
            		height.setText(reader.readLine());
            		concerns.setText(reader.readLine());
            		temp.setText(reader.readLine());
            		issues.setText(reader.readLine());
            		medications.setText(reader.readLine());
            		immunizations.setText(reader.readLine());
            		systolic.setText(reader.readLine());
            		diastolic.setText(reader.readLine());
            		
            		error.setVisible(false);
            		
            		return true;
                } 
                    
                catch (IOException e) 
                {
                	e.printStackTrace();
                }
            }
        }
        error.setText("Patient Does not Exist; Enter Another Name");
    	
    	return false;
	}
	
	
}
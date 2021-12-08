package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Presence implements Initializable{

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private JFXTextField text1;

    @FXML
    private JFXTextField text2;
    @FXML
    private JFXButton closeButton;
    
    public void updateStudents(ActionEvent e) throws IOException,ParseException{
		
    	//	String sid =  id.getText();
    	//	int id1 = Integer.parseInt(sid);
    		
    		String student1 = text1.getText();
    		String student2 = text2.getText();
    		
    		
    		Reunion1 stu = new Reunion1();
    		
    		//stu.setId(id1);
    		stu.setDate(Global2.dateedit);
    		stu.setIdencadrant(Global1.idencadrant);
    		stu.setStudent1(student1);
    		stu.setStudent2(student2);
    		
    		
    		
    		int status = DBGroup.updater(stu);
    		if(status>0) {
    			
    			Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setTitle("Data Update");
    			alert.setHeaderText("Information Dialog");
    			alert.setContentText("Record updated successfully");
    			
    			alert.showAndWait();
    			//System.out.println("Record saved successfully");
    		}
    		
    		else {
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Data Update");
    			alert.setHeaderText("ERROR Dialog");
    			alert.setContentText("Sorry! unable to update record");
    			
    			alert.showAndWait();
    			
    			//System.out.println("Sorry! unable to save record");
    			
    		}
    		Stage stage = (Stage) closeButton.getScene().getWindow();
    	    stage.close();

    		
    		
    		
    	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		label1.setText(Global2.student1);
		label2.setText(Global2.student2);
		
	}
    
    

	
				
		}

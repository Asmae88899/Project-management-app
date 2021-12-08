package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class EditMeeting implements Initializable{
	@FXML
    private JFXTextField time;
	@FXML
    private DatePicker date;
	
	@FXML
    private JFXButton closeButton;
	public void ShowDate(ActionEvent e) throws IOException
	{
		LocalDate ld=date.getValue();
		Global2.date1=ld.toString();
		
	}

	public void insertData(ActionEvent e) throws IOException{
	
		Reunion2 stu = new Reunion2();	
		//stu.setId(id1);
		stu.setIdgroup(Global2.idgroup2);
		stu.setDate(Global2.date1+"   "+time.getText());
	
		int status = DBGroup.updater2(stu);
		
		
        Reunion1 gr=new Reunion1();
	
		
		gr.setDate(Global2.date1+"   "+time.getText()); 
		gr.setIdgroup(Global2.idgroup2);
		gr.setIdencadrant(Global1.idencadrant);
		
		
	
		
		int status1=DBSujetsModifiable.saver1(gr);
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
		
	}

}

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

public class EditTask implements Initializable{
	@FXML
    private JFXTextField task1;
	@FXML
    private JFXTextField task2;
	@FXML
    private JFXTextField task3;
	@FXML
    private JFXTextField task4;
	@FXML
    private JFXTextField task5;
	
	
	@FXML
    private JFXButton closeButton;
	
	
	public void insertData(ActionEvent e) throws IOException{
	
		Task stu = new Task();	
		//stu.setId(id1);
		stu.setTask1(task1.getText());
		stu.setTask2(task2.getText());
		stu.setTask3(task3.getText());
		stu.setTask4(task4.getText());
		stu.setTask5(task5.getText());
	
		int status = DBGroup.updatetask(stu);
		
		
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
		
		
		
		
		Task stu =DBGroup.getinfotask(Global1.idgroup);
		
	//	id.setText(String.valueOf(stu.getId()));
		task1.setText(stu.getTask1());
		task2.setText(stu.getTask2());
		task3.setText(stu.getTask3());
		task4.setText(stu.getTask4());
		task5.setText(stu.getTask5());
		
	}

}

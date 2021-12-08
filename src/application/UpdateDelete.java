package application;

import java.io.IOException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/*
public class UpdateDelete {
	 @FXML
	TextField idStudent;
	@FXML
	private TextField datereunion;
	
	public void getStudentById(ActionEvent e) throws IOException, ParseException{
		
		String sid=idStudent.getText();
		int id=Integer.parseInt(sid);
		
		Students std=DBInfo.getStudentsId(id);
		
		datereunion.setText(std.getDate());
		
		
	}

	public void updateStudent(ActionEvent e) throws IOException, ParseException{
		
		String sid=idStudent.getText();
		int id=Integer.parseInt(sid);
		
		String textDate= datereunion.getText();
		
		Students std=new Students();
		
		std.setId(id);
		std.setDate(textDate);
		
		int status=DBInfo.update(std);
		if(status>0) {
			
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Data update");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record updated successsfully!");
			
			alert.showAndWait();
			
			
			
			
		}else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Data update");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Unable to update record");
			
			alert.showAndWait();
			
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}*/

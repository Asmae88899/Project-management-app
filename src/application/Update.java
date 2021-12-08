package application;

import java.io.IOException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Update {
	
	
	@FXML
	private TextField id1;
	@FXML
	private TextField nom1;
	@FXML
	private TextField pr�nom1;
	@FXML
	private TextField fili�re1;
	@FXML
	private TextField contact1;
	
	
	
	public void getStudentsByld(ActionEvent e) throws IOException,ParseException{
		
		String sid =  id1.getText();
		int id2 = Integer.parseInt(sid);
		
		Students1 stu =StudentsDB.getStudents(id2);
		
		id1.setText(String.valueOf(stu.getId()));
		nom1.setText(stu.getNom());
		pr�nom1.setText(stu.getPr�nom());
		fili�re1.setText(stu.getFili�re());
		contact1.setText(stu.getContact());
		
	
	}	
	
	
	public void updateStudents(ActionEvent e) throws IOException,ParseException{
		
		String sid =  id1.getText();
		int id2 = Integer.parseInt(sid);
		
		
		
		String nom2 = nom1.getText();
		String pr�nom2 = pr�nom1.getText();
		String fili�re2 = fili�re1.getText();
		String contact2 = contact1.getText();
		
		Students1 stu = new Students1();
		
		stu.setId(id2);
		stu.setNom(nom2);
		stu.setPr�nom(pr�nom2);
		stu.setFili�re(fili�re2);
		
		stu.setContact(contact2);
		
		
		int status = StudentsDB.update(stu);
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
		
		
		
	}
	

}

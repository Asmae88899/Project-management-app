package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Information implements Initializable {
	

	@FXML
    private JFXTextField contact;

    @FXML
    private JFXTextField filière;

    @FXML
    private JFXTextField prènom;

    @FXML
    private JFXTextField nom;
	
	
	
	
	
	
	

	
	
	public void updateStudents(ActionEvent e) throws IOException,ParseException{
		
	//	String sid =  id.getText();
	//	int id1 = Integer.parseInt(sid);
		
		
		
		String username1 = Global.a;
		String password1 = Global.b;
		String nom1 = nom.getText();
		String prènom1 = prènom.getText();
		String filière1 = filière.getText();
		String contact1 = contact.getText();
		
		Etudiant stu = new Etudiant();
		
		//stu.setId(id1);
		stu.setUsername(username1);
		stu.setPassword(password1);
		stu.setNom(nom1);
		stu.setPrènom(prènom1);
		stu.setFilière(filière1);
		
		stu.setContact(contact1);
		
		
		int status = EtudiantDB.update(stu);
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


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String sid =  Global.a;
		String si =  Global.b;
		
		
		Etudiant stu =EtudiantDB.getinfo(sid,si);
		
	//	id.setText(String.valueOf(stu.getId()));
		nom.setText(stu.getNom());
		prènom.setText(stu.getPrènom());
		filière.setText(stu.getFilière());
		contact.setText(stu.getContact());
		
		
		
		
	}
	
	
	
	
}

package application;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.ParseException;
import java.util.ResourceBundle;

public class EtudReun implements Initializable {
	
	
	
	@FXML
	private Label date;
	
	
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String sid =  Global.a;
		String si =  Global.b;
		
		
		Reunion2  stu =EtudiantDB.getinfo_r(sid,si);
		
		
		date.setText(stu.getDate());
	}	
	

}

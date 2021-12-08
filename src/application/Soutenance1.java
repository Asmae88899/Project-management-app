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

public class Soutenance1 implements Initializable {
	
	
	
	@FXML
	private Label numsalle;
	@FXML
	private Label datesou;
	
	
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String sid =  Global.a;
		String si =  Global.b;
		
		
		Soutenance stu =EtudiantDB.getinfo_so(sid,si);
		
		
		numsalle.setText(String.valueOf(stu.getNumsalle()));
		datesou.setText(stu.getDatesou());
	}	
	

}

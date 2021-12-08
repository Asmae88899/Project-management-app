package application;

import java.io.IOException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class UpDeReunions {
	
	@FXML
	TextField id;
	@FXML
	private TextField datereunion;
	
	public void getReunionById(ActionEvent e) throws IOException, ParseException{
		
		String sid=id.getText();
		int id1=Integer.parseInt(sid);
		
		Reunions re=DBReunion.getReunionsId(id1);
				
		
		datereunion.setText(re.getDatereunion());
		
		
	}

	public void updateReunion(ActionEvent e) throws IOException, ParseException{
		
		String sid=id.getText();
		int id=Integer.parseInt(sid);
		
		String textDate= datereunion.getText();
		
		Reunions re=new Reunions();
		
		re.setIdgroup(id);
		re.setDatereunion(textDate);
		
		int status=DBReunion.update(re);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

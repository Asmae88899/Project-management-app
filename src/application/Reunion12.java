package application;



import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Reunion12 implements Initializable {
	
	
	@FXML
	private AnchorPane mainPane;
	

	
	
	public void schedule(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Scheduling");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	


	public void history(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("History");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	/*public void updateDeleteStudents(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("UpDeReunions");
		mainPane.getChildren().addAll(view);
		
	}*/
	
	




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Scheduling");
		mainPane.getChildren().addAll(view);
		
	}
	
	

	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}

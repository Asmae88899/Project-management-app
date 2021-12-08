package application;



import java.io.IOException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class ContolPanel {
	
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	@FXML
	private AnchorPane mainPane;
	@FXML
	AnchorPane logoutPane;

	
	
	
	public void myFunction(String text){
		label1.setText(text);
		Global1.a=text;
    	
    
    	
    }
	public void yFunction(String text){
    	label2.setText(text);
        Global1.b=text;
    	
    }
	
	
	public void createSujet(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("SujetPanel");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	


	public void viewStudents(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("ViewStudents");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	/*public void updateDeleteStudents(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("UpDeReunions");
		mainPane.getChildren().addAll(view);
		
	}*/
	
	public void viewReunions(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("reunion12");
		mainPane.getChildren().addAll(view);
		
		
	}
	public void message(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Message1");
		mainPane.getChildren().addAll(view);
		
		
	}
	public void progress(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("ViewProgress");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	public void home(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Home3");
		mainPane.getChildren().addAll(view);
		
	}
	
	
public void logout(ActionEvent e) throws IOException,ParseException{
		
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("Fresh.fxml"));
		logoutPane.getChildren().addAll(pane1);
		
	}

	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}

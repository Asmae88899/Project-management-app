package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class Controller implements Initializable{
	
	
	
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	
	
	
	@FXML
	private AnchorPane mainPane;
	
	@FXML
	private AnchorPane pane;
	
	
	
	
	
	
	public void myFunction(String text){
		label1.setText(text);
		Global.a=text;
    	
    
    	
    }
	public void yFunction(String text){
    	label2.setText(text);
        Global.b=text;
    	
    }
	


	public void info(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Information");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	
	
	public void soutenance(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Soutenance1");
		mainPane.getChildren().addAll(view);
		
	}
	
	public void message(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Message2");
		mainPane.getChildren().addAll(view);
		
	}
	
	
	public void home(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Home1");
		mainPane.getChildren().addAll(view);
		
	}
	
	
	public void project(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("ProjectMenu");
		mainPane.getChildren().addAll(view);
		
	}
	
	public void progress(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Tasks");
		mainPane.getChildren().addAll(view);
		
	}
	
	public void meeting(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("EtudReun");
		mainPane.getChildren().addAll(view);
		
	}
	
	
		
	
	
	
	
	
	
	
	
	public void logout(ActionEvent e) throws IOException,ParseException{
		
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("Fresh.fxml"));
		pane.getChildren().addAll(pane1);
		
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

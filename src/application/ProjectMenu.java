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

public class ProjectMenu implements Initializable{
	
	
	
	
	@FXML
	private AnchorPane mainPane;

	

	public void encadrant(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Encadrant1");
		mainPane.getChildren().addAll(view);
		
	}
	
	public void binome(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Binome1");
		mainPane.getChildren().addAll(view);
		
	}
	
	
	public void sujet(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Sujet1");
		mainPane.getChildren().addAll(view);
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

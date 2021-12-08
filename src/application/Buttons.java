package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Buttons  {

	@FXML
	private Label label1;
	@FXML
	private Label label2;
	
	
	
	
	
	
	
	
	@FXML
	private AnchorPane pane;
	
	@FXML
	private AnchorPane mainPane;
	
	
	
	public void myFunction(String text){
		label1.setText(text);
		Global2.a=text;
    	
    
    	
    }
	public void yFunction(String text){
    	label2.setText(text);
        Global2.b=text;
    	
    }
	
	public void ProjetView(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("ProjetPanel");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	public void viewStudents(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("View");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	public void updateDeleteStudents(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Update");
		mainPane.getChildren().addAll(view);
		
	}
	
	
	public void home(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Home2");
		mainPane.getChildren().addAll(view);
		
	}
	
	/*public void logout(ActionEvent e) throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Interface.fxml"));
		
		pane.getChildren().addAll(pane);
		
	}*/
public void logout(ActionEvent e) throws IOException,ParseException{
		
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("Fresh.fxml"));
		pane.getChildren().addAll(pane1);
		
	}

	
	

}

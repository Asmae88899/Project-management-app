package application;

import java.io.IOException;

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


public class Fresh {
	
	@FXML
	private AnchorPane mainPane;
	
	
	
	public void login(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Interface2");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	


	public void about(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("AboutNew");
		mainPane.getChildren().addAll(view);
		
		
	}
	
	public void contact(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Contact");
		mainPane.getChildren().addAll(view);
		
	}
	
	public void home(ActionEvent e) throws IOException{
		FXMLLoader Loader= new FXMLLoader(getClass().getResource("Fresh.fxml"));
		Parent root = Loader.load();
		
		Scene scene = new Scene(root);
		Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		
	}

}

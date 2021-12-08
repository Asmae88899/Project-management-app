package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Interface2 implements Initializable {
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	private void load1(ActionEvent e) throws IOException {
		
		FXMLLoader Loader= new FXMLLoader(getClass().getResource("Fxml1.fxml"));
		Parent root = Loader.load();
		Scene scene = new Scene(root);
		Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	
	@FXML
	private void load2(ActionEvent e) throws IOException {
		
		FXMLLoader Loader= new FXMLLoader(getClass().getResource("Fxml2.fxml"));
		Parent root = Loader.load();
		
		Scene scene = new Scene(root);
		Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();

	}
	
	
	
	@FXML
	private void loads3(ActionEvent e) throws IOException {
		
		FXMLLoader Loader= new FXMLLoader(getClass().getResource("LoginStudent.fxml"));
		Parent root = Loader.load();
		
		Scene scene = new Scene(root);
		Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
}
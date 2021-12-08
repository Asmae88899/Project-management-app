package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Login1 implements Initializable {
	
	@FXML
	private AnchorPane rootPane;
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	private void load1(ActionEvent event) throws IOException {
		
		AnchorPane pane1 = FXMLLoader.load(getClass().getResource("Fxml1.fxml"));
		rootPane.getChildren().setAll(pane1);

	}
	
	
	@FXML
	private void load2(ActionEvent event) throws IOException {
		
		AnchorPane pane2 = FXMLLoader.load(getClass().getResource("Fxml2.fxml"));
		rootPane.getChildren().setAll(pane2);

	}
	
	
	
	@FXML
	private void loads3(ActionEvent event) throws IOException {
		
		AnchorPane pane3 = FXMLLoader.load(getClass().getResource("LoginStudent.fxml"));
		rootPane.getChildren().setAll(pane3);

	}
	
	
	@FXML
	private void loads4(ActionEvent event) throws IOException {
		
		AnchorPane pane4 = FXMLLoader.load(getClass().getResource("About.fxml"));
		rootPane.getChildren().setAll(pane4);

	}
	
}

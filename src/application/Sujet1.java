package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Sujet1 implements Initializable {
	
	
	
	@FXML
	private Label nom_s;
	@FXML
	private Label document_s;
	@FXML
	private AnchorPane mainPane;
	@FXML
    private JFXTextArea text;
	
	public void back(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("ProjectMenu");
		mainPane.getChildren().addAll(view);
		
	}
	
	
	



@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	String sid =  Global.a;
	String si =  Global.b;
		
		
		Sujet stu =EtudiantDB.getinfo_s(sid,si);
		
		nom_s.setText(stu.getNom_s());
		document_s.setText(stu.getDocument_s());
		text.setText(stu.getDescription());
}	
	

}

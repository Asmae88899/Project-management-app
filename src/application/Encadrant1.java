package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Encadrant1 implements Initializable {
	
	//@FXML
	//  private Label date_e;

    @FXML
    private Label contact_e;

    @FXML
    private Label prènom_e;

    @FXML
    private Label nom_e;

    @FXML
  	private AnchorPane mainPane;
  	
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
	
	
	Encadrant stu =EtudiantDB.getinfo_e(sid,si);
	
	
	nom_e.setText(stu.getNom_e());
	prènom_e.setText(stu.getPrènom_e());
	contact_e.setText(stu.getContact_e());
	//date_e.setText(stu.getDate_e());
}

}

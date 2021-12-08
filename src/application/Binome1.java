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

public class Binome1 implements Initializable {
	
	
	@FXML
    private Label contact_b;

    @FXML
    private Label pr�nom_b;

    @FXML
    private Label nom_b;

    @FXML
    private Label fili�re_b;
    
    
    @FXML
	private AnchorPane mainPane;
	
	public void back(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("ProjectMenu");
		mainPane.getChildren().addAll(view);
		
	}
	

	
	



	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//String sid =  Global.a;
	//String si =  Global.b;
		
	
		Etudiant stu =EtudiantDB.getinfob(Global1.y,Global.a);
		
		
		nom_b.setText(stu.getNom());
		pr�nom_b.setText(stu.getPr�nom());
		fili�re_b.setText(stu.getFili�re());
		contact_b.setText(stu.getContact());
	
}
	

}

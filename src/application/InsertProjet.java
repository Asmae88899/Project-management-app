package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*public class InsertProjet {
	
	@FXML
	TextField nom;
	@FXML
	Label idgroupl;
	
	
	
	@FXML
	private AnchorPane mainPane;
	
	
	
	public void insertData(ActionEvent e) throws IOException{
		String nomProjet = nom.getText();
		
		Projets pr=new Projets();
		Group gr=new Group();
		
		pr.setNom(nomProjet);
		gr.setNom(nomProjet);
		
		int status=DBProjet.save(pr);
		int status1=DBGroup.save(gr);
		
		
		if(status>0) {
			
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record saved successsfully!");
			
			alert.showAndWait();
			
			
			
			
		}else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Data Insert");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Unable to save record");
			
			alert.showAndWait();
			
			}
if(status1>0) {
			
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record saved successsfully!");
			
			alert.showAndWait();
			
			
			
			
		}else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Data Insert");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Unable to save record");
			
			alert.showAndWait();
			
			}
		
		
	}
	
	
	public void getGroupId(ActionEvent e) throws IOException, ParseException{
		
		String sid= nom.getText();
	
		
		Group re=DBGroup.getGroupId(sid);
				
		Global2.c=re.getIdgroup();
		System.out.print(Global2.c);
		datereunion.setText(re.getIdgroup());
	
		
		
		}
		
		
		
		public void view(ActionEvent e) throws IOException{
			
			
			
			FXMLLoader Loader= new FXMLLoader(getClass().getResource("EtudiantPanel.fxml"));
			Parent root = Loader.load();
			EtudiantPanel con = Loader.getController();
			con.myFunction(nom.getText());
			
			Scene scene = new Scene(root);
			Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		
			
			
		}
	

	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}*/

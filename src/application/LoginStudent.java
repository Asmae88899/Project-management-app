package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginStudent implements Initializable {

	@FXML
	private AnchorPane rootPane2;
	@FXML
    private AnchorPane rootPane1;
	
	
	@FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;
	@FXML
	Label check;
	
	
	
public void back(ActionEvent e) throws IOException,ParseException{
		
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("Fresh.fxml"));
		rootPane1.getChildren().addAll(pane1);
		
	}
	
	
	
	
	public void EnterCP(ActionEvent e) throws IOException,SQLException{
		

		
		ObservableList<Etudiant>data1=FXCollections.observableArrayList();

		try {
			 
			 String sql= "SELECT idgroup,nom,prènom,filière,contact FROM etudiant WHERE username=? AND password=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,username.getText());
			 preparedStatement.setString(2,password.getText());
			 
			 
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 data1.add(new Etudiant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
				 
			 }
			 con.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for (Etudiant gr : data1 )
		{
	    	Global1.idgroup=gr.getIdgroup();
			
	    	
	    	
		}
		
		
		
		ObservableList<EtudiantBin>data=FXCollections.observableArrayList();

		try {
			 
			 String sql= "SELECT idetudiant,nom,prènom,filière,contact,idgroup FROM `etudiant` WHERE username=? AND password=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,username.getText());
			 preparedStatement.setString(2,password.getText());
			 
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 data.add(new EtudiantBin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
				 
			 }
			 con.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for (EtudiantBin gr : data )
		{
	    	
			Global1.y=gr.getIdgroup();
			System.out.print(Global1.y);
	    	
	    	
	    	
		}
		
		
		List<Etudiant> list = EtudiantDB.getAdmins();
		
		Map<String,String> map= new HashMap<String,String>();
		
		
		for(Etudiant a:list) {
			map.put(a.getUsername(),a.getPassword());
		}
		
		
		if(map.containsKey(username.getText())) {
			String val2=map.get(username.getText());
			if(val2.equals(password.getText())) {
				check.setText("Success");
				EtudiantDB.getConnection();
				
				
				FXMLLoader Loader= new FXMLLoader(getClass().getResource("Student.fxml"));
				Parent root = Loader.load();
				Controller con = Loader.getController();
				con.myFunction(username.getText());
				con.yFunction(password.getText());
				Scene scene = new Scene(root);
				Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();
				
				
				//AnchorPane pane = FXMLLoader.load(getClass().getResource("Student.fxml"));
				//rootPane2.getChildren().setAll(pane);
				
				
				//Stage primaryStage = new Stage();
				//Parent root = FXMLLoader.load(getClass().getResource("ControlPanel.fxml"));
				
				
				//Scene scene = new Scene(root,700,500);
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				
				//primaryStage.setScene(scene);
				//primaryStage.show();
			
				
			}else {
				check.setText("Failed try again");
		}
			
			
			
			
		}else {
			check.setText("Failed try again");
		}	
		
	}
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

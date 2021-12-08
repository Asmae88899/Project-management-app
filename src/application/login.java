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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class login {
	//@FXML
	//Label dbconlb;
	
	 @FXML
	private JFXTextField username;

	 @FXML
	 private JFXPasswordField password;
	@FXML
	Label check;
	@FXML
	AnchorPane rootPane;
	
	
	
public void back(ActionEvent e) throws IOException,ParseException{
		
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("Fresh.fxml"));
		rootPane.getChildren().addAll(pane1);
		
	}
	
	
	
	//public void statusDB(ActionEvent e) throws IOException, SQLException{
	//if(!AdminsDB.getConnection().isClosed()) {
	//dbconlb.setText("Connected");
		
	//}else {
	//	dbconlb.setText("Not connected");
		
	//}
	
	
	//}	

	
	
	public void enterCP(ActionEvent e)throws IOException, SQLException{
		
		ObservableList<Admins>data1=FXCollections.observableArrayList();

		try {
			 
			 String sql= "SELECT idencadrant FROM encadrant WHERE username=? AND password=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,username.getText());
			 preparedStatement.setString(2,password.getText());
			 
			 
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 data1.add(new Admins(rs.getInt(1)));
				 
			 }
			 con.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for (Admins gr : data1 )
		{
	    	Global1.idencadrant=gr.getId();
			
	    	
	    	
		}
		
		
		
		
		List<Admins>list=AdminsDB.getAdmins();
		
		Map<String,String>map=new HashMap<String,String>();
		
		for(Admins a:list) {
			map.put(a.getUsername(),a.getPassword());
			
		}
		
if(map.containsKey(username.getText())) {
	
	String val2=map.get(username.getText());
	if(val2.equals(password.getText())){
		check.setText("Success");
		
		AdminsDB.getConnection();
		

		FXMLLoader Loader= new FXMLLoader(getClass().getResource("ControlPanel.fxml"));
		Parent root = Loader.load();
		ContolPanel con = Loader.getController();
		con.myFunction(username.getText());
		con.yFunction(password.getText());
		Scene scene = new Scene(root);
		Stage window= (Stage)((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	
		
	}else {
		check.setText("Failed try again");
	}
		
	}else {
		check.setText("Failed try again");
	}
}



		
	
	

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
}


 
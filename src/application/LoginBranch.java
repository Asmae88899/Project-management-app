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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginBranch implements Initializable {
	
	
	@FXML
	private AnchorPane rootPane1;
	
	
	 @FXML
	private JFXTextField username;

	 @FXML
	 private JFXPasswordField password;

	@FXML
	Label check;
	@FXML
    private AnchorPane MainPane;
	
	
public void back(ActionEvent e) throws IOException,ParseException{
		
		AnchorPane pane1=FXMLLoader.load(getClass().getResource("Fresh.fxml"));
		MainPane.getChildren().addAll(pane1);
		
	}

	
	@FXML
	public void EnterCP(ActionEvent e) throws IOException,SQLException{
		
		ObservableList<Branch>data1=FXCollections.observableArrayList();

		try {
			 
			 String sql= "SELECT idchef FROM chef WHERE username=? AND password=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,username.getText());
			 preparedStatement.setString(2,password.getText());
			 
			 
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 data1.add(new Branch(rs.getInt(1)));
				 
			 }
			 con.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		for (Branch gr : data1 )
		{
	    	Global1.idchef=gr.getIdchef();
			
	    	
	    	
		}
		
		
		
		List<Branch> list = BranchDB.getBranch();
		
		Map<String,String> map= new HashMap<String,String>();
		
		
		for(Branch a:list) {
			map.put(a.getUsername(),a.getPassword());
		}
		
		
		if(map.containsKey(username.getText())) {
			String val2=map.get(username.getText());
			if(val2.equals(password.getText())) {
				check.setText("Success");
				BranchDB.getConnection();
				
				
				//AnchorPane pane = FXMLLoader.load(getClass().getResource("Branch.fxml"));
				//rootPane1.getChildren().setAll(pane);
				FXMLLoader Loader= new FXMLLoader(getClass().getResource("Branch.fxml"));
				Parent root = Loader.load();
				Buttons con = Loader.getController();
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

}

package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Message2 implements Initializable{
	

	@FXML
    private TableView<Reunions> table;

    @FXML
    private TableColumn<Reunions,Integer>idgroup;
    
    @FXML
    private TableColumn<Reunions,String>datereunion;

 
 
    
public ObservableList<Reunions>data=FXCollections.observableArrayList();

  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			 
			 String sql= "SELECT r.idrèunion , r.date  FROM reunion as r JOIN encadrant as p ON p.idencadrant=r.idencadrant WHERE p.username=? AND p.password=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setString(1,Global1.a);
			 preparedStatement.setString(2,Global1.b);
			 
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 data.add(new Reunions(rs.getInt(1),rs.getString(2)));
				 
			 }
			 con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		idgroup.setCellValueFactory(new PropertyValueFactory<Reunions,Integer>("idgroup"));
		datereunion.setCellValueFactory(new PropertyValueFactory<Reunions,String>("datereunion"));
		
		
		table.setItems(data);

		
		
		
		
	}
}
	

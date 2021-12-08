package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.Predicate;


import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableHistory implements Initializable {
	
	@FXML
	private TableView<Reunion1>table;

   
	@FXML
	private TableColumn<Reunion1,String>date;
	@FXML
	private TableColumn<Reunion1,String>student1;
	
	@FXML
	private TableColumn<Reunion1,String>student2;
	
	public ObservableList<Reunion1> data=FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		student1.setText(Global2.student11);
		student2.setText(Global2.student22);
		try {
			String sql= "SELECT date,idencadrant,idgroup,student1,student2 FROM reunion1  WHERE idgroup=? AND idencadrant=?";
			Connection con =StudentsDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,Global2.idgroup1);
			preparedStatement.setInt(2,Global1.idencadrant);
			ResultSet rs =preparedStatement.executeQuery();
			
			while(rs.next()) {
				data.add(new Reunion1(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
				
			}
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		date.setCellValueFactory(new PropertyValueFactory<Reunion1,String>("date"));
		student1.setCellValueFactory(new PropertyValueFactory<Reunion1,String>("student1"));
		
		student2.setCellValueFactory(new PropertyValueFactory<Reunion1,String>("student2"));
		
		
		table.setItems(data);
		
		
		
		
	}
	
	

}

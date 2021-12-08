package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

public class View1 implements Initializable {
	@FXML
    private JFXTextField filterField;
	
	@FXML
	private TableView<Encadrant>table;
	
	@FXML
	private TableColumn<Encadrant,String>nom;
	@FXML
	private TableColumn<Encadrant,String>prènom;
	
	@FXML
	private TableColumn<Encadrant,String>contact;
	
	public ObservableList<Encadrant> data=FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			String sql= "SELECT idencadrant, nom, prènom, contact FROM encadrant WHERE idencadrant NOT LIKE 1";
			Connection con =BranchDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
		
			ResultSet rs =preparedStatement.executeQuery();
			
			while(rs.next()) {
				data.add(new Encadrant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
				
			}
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		nom.setCellValueFactory(new PropertyValueFactory<Encadrant,String>("nom_e"));
		prènom.setCellValueFactory(new PropertyValueFactory<Encadrant,String>("prènom_e"));
		contact.setCellValueFactory(new PropertyValueFactory<Encadrant,String>("contact_e"));
		
		
		table.setItems(data);
		
		
		FilteredList<Encadrant> filteredData = new FilteredList<>(data, e-> true);
		filterField.setOnKeyReleased(e ->{
			filterField.textProperty().addListener((observableValue,oldValue,newValue) ->{
				filteredData.setPredicate(user->{
					
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					
					String lowerCaseFilter= newValue.toLowerCase();
					if(user.getNom_e().toLowerCase().contains(lowerCaseFilter))  {
						return true;
					}else if (user.getPrènom_e().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}
					return false;
						
					
					
				}); 
			});
			
			
			SortedList<Encadrant> sortedData= new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);
		});
		
	}
	
	

}

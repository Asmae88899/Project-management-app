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

public class View implements Initializable {
	 @FXML
    private JFXTextField filterField;
	
	@FXML
	private TableView<Students1>table;

   
	@FXML
	private TableColumn<Students1,String>nom;
	@FXML
	private TableColumn<Students1,String>prènom;
	
	@FXML
	private TableColumn<Students1,String>contact;
	
	public ObservableList<Students1> data=FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			String sql= "SELECT e.idetudiant,e.nom,e.prènom,e.filière,e.contact FROM etudiant as e JOIN chef as c ON e.idchef=c.idchef  WHERE c.username=? AND c.password=? AND e.idetudiant NOT LIKE 14";
			Connection con =StudentsDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setString(1,Global2.a);
			 preparedStatement.setString(2,Global2.b);
			ResultSet rs =preparedStatement.executeQuery();
			
			while(rs.next()) {
				data.add(new Students1(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
				
			}
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		nom.setCellValueFactory(new PropertyValueFactory<Students1,String>("nom"));
		prènom.setCellValueFactory(new PropertyValueFactory<Students1,String>("prènom"));
		
		contact.setCellValueFactory(new PropertyValueFactory<Students1,String>("contact"));
		
		
		table.setItems(data);
		
		FilteredList<Students1> filteredData = new FilteredList<>(data, e-> true);
		filterField.setOnKeyReleased(e ->{
			filterField.textProperty().addListener((observableValue,oldValue,newValue) ->{
				filteredData.setPredicate(user->{
					
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					
					String lowerCaseFilter= newValue.toLowerCase();
					if(user.getNom().toLowerCase().contains(lowerCaseFilter))  {
						return true;
					}else if (user.getPrènom().toLowerCase().contains(lowerCaseFilter)) {
						return true;
					}
					return false;
						
					
					
				}); 
			});
			
			
			SortedList<Students1> sortedData= new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);
		});
		
		
		
		
	}
	
	

}

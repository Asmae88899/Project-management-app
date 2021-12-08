package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

public class EncadrantPanel implements Initializable{
	
	
	@FXML
	private AnchorPane mainPane;

	@FXML
	private TableView<EncadrantModifiable>table;
	@FXML
	private TableColumn<EncadrantModifiable,Integer>id;
	
	@FXML
	private TableColumn<EncadrantModifiable,String>nom;
	@FXML
	private TableColumn<EncadrantModifiable,String>prènom;
	
	@FXML
    private JFXButton closeButton;

	
	
/*	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
	}
	
	
	
		public void changeCellEvent(CellEditEvent edittedCell)
	{
		StudentsModifiable StudentsModifiableSelected= table.getSelectionModel().getSelectedItem();
		Global2.x=StudentsModifiableSelected.getId();
		System.out.print(Global2.x);
		
	}*/
	
	
public void updateStudents(ActionEvent e) throws IOException,ParseException{
		
		
	//String nom2 = Global2.d;
		
		StudentsModifiable stu = new StudentsModifiable();
		//Group stu1 = new Group();
		//Reunions stu1 = new Reunions();
		stu.setIdencadtant(Global2.k);
		int status = DBGroup.update2(stu);
		//stu1.setNom(nom2);
		//stu1.setIdgroup(Global2.l);
		
		/*	List<Reunions>list=new ArrayList<Reunions>();
		list=DBReunion.getReunions1();
		for (Reunions stu1:list )
		{	
			stu1.setIdgroup(Global2.l);
			int status1 = DBGroup.update3(stu1);
	    	
	   }*/
		
	    
		
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();
		//int status1 = DBGroup.update1(stu1);
		/*if(status>0) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Update");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record updated successfully");
			
			alert.showAndWait();
			//System.out.println("Record saved successfully");
		}
		
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Update");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Sorry! unable to update record");
			
			alert.showAndWait();
			
			//System.out.println("Sorry! unable to save record");
			
		}*/
/*if(status1>0) {
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Update");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record updated successfully");
			
			alert.showAndWait();
			//System.out.println("Record saved successfully");
		}
		
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Update");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Sorry! unable to update record");
			
			alert.showAndWait();
			
			//System.out.println("Sorry! unable to save record");
			
		}
		*/


	
	
		
		
	}
	

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		id.setCellValueFactory(new PropertyValueFactory<EncadrantModifiable,Integer>("idencadrant"));
		nom.setCellValueFactory(new PropertyValueFactory<EncadrantModifiable,String>("nom_e"));
		prènom.setCellValueFactory(new PropertyValueFactory<EncadrantModifiable,String>("prènom_e"));

		
		
		table.setItems(getValue());
		table.setEditable(true);
		
		
	  

		
		

	}
	
	public void Push()
	{
		List<String> list = new ArrayList<String>();
		
		
		ObservableList<EncadrantModifiable> selectedRows;
		selectedRows= table.getSelectionModel().getSelectedItems();
		
	    for (EncadrantModifiable liste:selectedRows )
		{
	    	
	    	
	    	list.add(Integer.toString(liste.getIdencadrant()));
	    	
	    	
		}
		
	    Global2.k=Integer.parseInt(list.get(0));
	   
	    
	    
		
		
		
	}

	private ObservableList<EncadrantModifiable> getValue() {
		// TODO Auto-generated method stub
		ObservableList<EncadrantModifiable> value=FXCollections.observableArrayList();
		try {
			String sql= "SELECT idencadrant,nom,prènom,contact FROM encadrant WHERE idencadrant NOT LIKE 1";
			Connection con =DBEncadrantModifiable.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
	
			ResultSet rs =preparedStatement.executeQuery();
			
			while(rs.next()) {
				value.add(new EncadrantModifiable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
				
			}
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	
		
		return value;
	}

	

	
}
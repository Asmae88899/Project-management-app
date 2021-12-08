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
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
/*
	public class GroupPanel implements Initializable{
	
	

	@FXML
	private AnchorPane mainPane;

	@FXML
	private TableView<StudentModifiable>table;
	@FXML
	private TableColumn<StudentModifiable,Integer>id;
	@FXML
    private JFXButton closeButton;

    @FXML
    private JFXTextField nom1;

    @FXML
    private JFXTextField nom2;
    
    
    
    @FXML
	private void show(){
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				List<String> list = new ArrayList<String>();
				
				
				
				ObservableList<SujetModifiable> selectedRows;
				selectedRows= table.getSelectionModel().getSelectedItems();
				
			    for (SujetModifiable liste:selectedRows )
				{
			    	
			    	
			    	list.add(liste.getNom_s());
			    
			    	
			    	
				}
				
			    Global2.u=list.get(0);
			    
				  ObservableList<SujetModifiable>data=FXCollections.observableArrayList();

                  try {
	 
	              String sql= "SELECT `idsujet`,`nom` ,`document` FROM `sujet` WHERE nom=?"; 
	              Connection con=AdminsDB.getConnection();
	              PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	              preparedStatement.setString(1, Global2.u);
	 
     ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data.add(new SujetModifiable(rs.getInt(1),rs.getString(2),rs.getString(3)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (SujetModifiable gr1 : data )
{
	Global2.m=gr1.getIdsujet();
	
}




ObservableList<Etudiant>data2=FXCollections.observableArrayList();

List<String> list1 = new ArrayList<String>();
try {
	 
	 String sql= "SELECT nom FROM etudiant WHERE idsujet=?"; 
	 Connection con=AdminsDB.getConnection();
	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	 preparedStatement.setInt(1, Global2.m);
	 
    ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data2.add(new Etudiant(rs.getString(1)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (Etudiant liste:data2 )
{
	
	
	list1.add(liste.getNom());
	
	
}

             nom1.setText(list1.get(0));
             nom2.setText(list1.get(1));
            
	
	}
	
				
			}
			
		);}
	
	
	
	
	
	/*	public void changeCellEvent(CellEditEvent edittedCell)
	{
		StudentsModifiable StudentsModifiableSelected= table.getSelectionModel().getSelectedItem();
		Global2.x=StudentsModifiableSelected.getId();
		System.out.print(Global2.x);
		
	}
	*/
		/*
public void updateStudents(ActionEvent e) throws IOException,ParseException{
		
		

	StudentModifiable stu = new StudentModifiable();
	//Group stu1 = new Group();
	//Reunions stu1 = new Reunions();
	 stu.setIdsujet(Global2.p);
	
	 int status = DBGroup.update4(stu);
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
		/*
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();



	
		
		
	}
	

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		id.setCellValueFactory(new PropertyValueFactory<StudentModifiable,Integer>("idgroup"));
		
		
		table.setItems(getValue());
		table.setEditable(true);
		
	
		
	  

		
		

	}
	
	public void Push()
	{
		List<String> list = new ArrayList<String>();
		
		
		ObservableList<StudentModifiable> selectedRows;
		selectedRows= table.getSelectionModel().getSelectedItems();
		
	    for (StudentModifiable liste:selectedRows )
		{
	    	
	    	
	    	list.add(Integer.toString(liste.getIdgroup()));
	    	
	    	
		}
		
	    Global2.h=Integer.parseInt(list.get(0));
	   
	    
	    
		
		
		
	}

	private ObservableList<StudentModifiable> getValue() {
		// TODO Auto-generated method stub
		ObservableList<StudentModifiable> value=FXCollections.observableArrayList();
		try {
			String sql= "SELECT s.idetudiant,s.nom,s.prènom,s.filière,s.contact,s.idgroup FROM `etudiant` as s JOIN `encadrant` as e ON s.idencadrant=e.idencadrant WHERE e.username=? AND e.password=? GROUP BY s.idgroup";
			Connection con =DBEtudiantModifiable.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setString(1,Global1.a);
			 preparedStatement.setString(2,Global1.b);
			ResultSet rs =preparedStatement.executeQuery();
			
			while(rs.next()) {
				value.add(new StudentModifiable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
				
			}
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	
		
		return value;
	}


	
}*/
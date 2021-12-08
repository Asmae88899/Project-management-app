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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

public class EtudiantPanel implements Initializable{
	
	
	@FXML
	private Label label1;
	@FXML
	private AnchorPane mainPane;

	@FXML
	private TableView<StudentsModifiable>table;
	@FXML
	private TableColumn<StudentsModifiable,Integer>id;
	@FXML
	private TableColumn<StudentsModifiable,String>nom;
	@FXML
	private TableColumn<StudentsModifiable,String>prènom;
	
	
	
	public void myFunction(String text){
		label1.setText(text);
		Global2.d=text;
	  }
	
	/*	public void changeCellEvent(CellEditEvent edittedCell)
	{
		StudentsModifiable StudentsModifiableSelected= table.getSelectionModel().getSelectedItem();
		Global2.x=StudentsModifiableSelected.getId();
		System.out.print(Global2.x);
		
	}*/
	
	
public void updateStudents(ActionEvent e) throws IOException,ParseException{
		
		
		String nom2 = Global2.d;
		
		Group stu = new Group();
		Group stu1 = new Group();
		
		stu.setNom(nom2);
		stu1.setNom(nom2);
		
		
		
		int status = DBGroup.update(stu);
		int status1 = DBGroup.update1(stu1);
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


FxmlLoader object = new FxmlLoader();
Pane view = object.getPage("EncadrantPanel");
mainPane.getChildren().addAll(view);
		
	
	
		
		
	}
	

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		id.setCellValueFactory(new PropertyValueFactory<StudentsModifiable,Integer>("id"));
		nom.setCellValueFactory(new PropertyValueFactory<StudentsModifiable,String>("nom"));
		prènom.setCellValueFactory(new PropertyValueFactory<StudentsModifiable,String>("prènom"));
		
		table.setItems(getValue());
		table.setEditable(true);
		
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		
	  

		
		

	}
	
	public void Push()
	{
		List<String> list = new ArrayList<String>();
		
		
		ObservableList<StudentsModifiable> selectedRows;
		selectedRows= table.getSelectionModel().getSelectedItems();
		
	    for (StudentsModifiable liste:selectedRows )
		{
	    	
	    	
	    	list.add(Integer.toString(liste.getId()));
	    	
	    	
		}
		
	    Global2.x=Integer.parseInt(list.get(0));
	    Global2.y=Integer.parseInt(list.get(1));
	    
	    
	    
		
		
		
	}

	private ObservableList<StudentsModifiable> getValue() {
		// TODO Auto-generated method stub
		ObservableList<StudentsModifiable> value=FXCollections.observableArrayList();
		try {
			String sql= "SELECT e.idetudiant,e.nom,e.prènom,e.filière,e.contact FROM etudiant as e JOIN chef as c ON e.idchef=c.idchef  WHERE c.username=? AND c.password=? AND e.idetudiant NOT LIKE 14";
			Connection con =DBEtudiantModifiable.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setString(1,Global2.a);
			 preparedStatement.setString(2,Global2.b);
			ResultSet rs =preparedStatement.executeQuery();
			
			while(rs.next()) {
				value.add(new StudentsModifiable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
				
			}
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	
		
		return value;
	}

	

	
}
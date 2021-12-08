package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SujetPanel implements Initializable{

	@FXML
    private TableView<SujetModifiable> table;

  
    @FXML
    private TableColumn<SujetModifiable,String>nom;
    @FXML
    private TableColumn<SujetModifiable,String>document;
    @FXML
	private AnchorPane mainPane;

    @FXML
    private JFXTextField nom1;

    @FXML
    private JFXTextField nom2;
    @FXML
    private JFXTextArea theme;
    @FXML
    private JFXTextArea description;

    @FXML
    private JFXTextArea tech;
    
    
    
    public void refresh(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("SujetPanel");
		mainPane.getChildren().addAll(view);
		
		
	}
    

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
			    	theme.setText(liste.getNom_s());
			    	tech.setText(liste.getDocument_s());
			    	
			    	
				}
				
			    Global2.u=list.get(0);
			    
				  ObservableList<SujetModifiable>data=FXCollections.observableArrayList();

                  try {
	 
	              String sql= "SELECT `idsujet`,`nom` ,`document`,`description` FROM `sujet` WHERE nom=?"; 
	              Connection con=AdminsDB.getConnection();
	              PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	              preparedStatement.setString(1, Global2.u);
	 
     ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data.add(new SujetModifiable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (SujetModifiable gr1 : data )
{
	Global2.m=gr1.getIdsujet();
	Global2.des=gr1.getDescription();
	
}

description.setText(Global2.des);


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

    
    
    
    
    
    
    
    
  

	public void add(ActionEvent e) throws IOException{
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("InsertSujet.fxml"));
		
		Scene scene = new Scene(root,605,422);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		nom.setCellValueFactory(new PropertyValueFactory<SujetModifiable,String>("nom_s"));
		document.setCellValueFactory(new PropertyValueFactory<SujetModifiable,String>("document_s"));
		table.setItems(getValue());
		

	}
	
	 /*	public void champPushed(ActionEvent e) throws IOException{
		
		//Group newProjet = new Group(champ.getText());
		
		//table.getItems().add(newProjet);
		
        String nomSujet = champ.getText();
		
        SujetModifiable pr=new SujetModifiable();
	
		
		pr.setNom_s(nomSujet); 
		pr.setNom_s(nomSujet);
	
		
		int status=DBProjet.save(pr);

		
		table.getItems().add(gr);
		
		
		if(status>0) {
			
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record saved successsfully!");
			
			alert.showAndWait();
			
			
			
			
		}else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Data Insert");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Unable to save record");
			
			alert.showAndWait();
			
			}
if(status1>0) {
			
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Data Insert");
			alert.setHeaderText("Information Dialog");
			alert.setContentText("Record saved successsfully!");
			
			alert.showAndWait();
			
			
			
			
		}else {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Data Insert");
			alert.setHeaderText("ERROR Dialog");
			alert.setContentText("Unable to save record");
			
			alert.showAndWait();
			
			}



ObservableList<Group>data=FXCollections.observableArrayList();

try {
	 
	 String sql= "SELECT `idgroup`, `nom` FROM `group` WHERE nom=?"; 
	 Connection con=AdminsDB.getConnection();
	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	 preparedStatement.setString(1,champ.getText());
	 
	 
     ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data.add(new Group(rs.getInt(1),rs.getString(2)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (Group gr1 : data )
{
	Global2.l=gr1.getIdgroup();
	
	
	
	
}



             Stage primaryStage=new Stage();
             FXMLLoader Loader= new FXMLLoader(getClass().getResource("EtudiantPanel.fxml"));
             Parent root = Loader.load();
             EtudiantPanel con = Loader.getController();
             con.myFunction(nom.getText());


             Scene scene = new Scene(root,808,400);
             scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

             primaryStage.setScene(scene);
             primaryStage.show();




		
		
	}
	*/
	
	

	private ObservableList<SujetModifiable> getValue() {
		// TODO Auto-generated method stub
		ObservableList<SujetModifiable> value=FXCollections.observableArrayList();
		
		try {
			 
			 String sql= "SELECT `idsujet`, s.nom , `document`, `description` FROM `sujet` as s JOIN `encadrant` as e ON s.idencadrant=e.idencadrant WHERE s.idencadrant=? "; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setInt(1,Global1.idencadrant);
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 value.add(new SujetModifiable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
				 
			 }
			 con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return value;
	}

	

	
}


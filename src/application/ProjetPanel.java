package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXListView;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProjetPanel implements Initializable{
	@FXML
    private JFXTextField encadrant;
	@FXML
    private TableView<Group> table;

    @FXML
    private TableColumn<Group,Integer>idprojet;
    
    @FXML
    private TableColumn<Group,String>nom;
    @FXML
	private AnchorPane mainPane;
    @FXML
    private JFXTextField champ;
    @FXML
    private JFXTextField nom1;

    @FXML
    private JFXTextField nom2;

	
    
    public void refresh(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("ProjetPanel");
		mainPane.getChildren().addAll(view);
		
		
	}
    
    
  

	/*public void add(ActionEvent e) throws IOException{
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("InsertProjet.fxml"));
		
		Scene scene = new Scene(root,808,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
}*/

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
			
		
		
		
		
		nom.setCellValueFactory(new PropertyValueFactory<Group,String>("nom"));
		
		table.setItems(getValue());
		
		/*ObservableList<Group>data=FXCollections.observableArrayList();

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
			try {
			Label lbl= new Label(gr1.getNom());
			listview.getItems().add(lbl);
			System.out.print(gr1.getNom());
			
			
		}catch (Exception ex) {
			Logger.getLogger(ProjetPanel.class.getName()).log(Level.SEVERE,null,ex);
			
		}		
		
					
	}
		
		
		
		
	for (Group gr1 :getValue()  )
		{
			try {
				Label lbl= new Label(gr1.getNom());
				listview.getItems().add(lbl);
			}catch (Exception ex) {
				Logger.getLogger(ProjetPanel.class.getName()).log(Level.SEVERE,null,ex);
				
			}		
			
						
		}*/
		
	

		


	}
	
	
	@FXML
	private void show(){
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				
				List<String> list = new ArrayList<String>();
				
				
				ObservableList<Group> selectedRows;
				selectedRows= table.getSelectionModel().getSelectedItems();
				
			    for (Group liste:selectedRows )
				{
			    	
			    	
			    	list.add(liste.getNom());
			    	
			    	
				}
				
			    Global2.s=list.get(0);
			   
				  ObservableList<Group>data=FXCollections.observableArrayList();

                  try {
	 
	              String sql= "SELECT `idgroup`, `nom` FROM `group` WHERE nom=?"; 
	              Connection con=AdminsDB.getConnection();
	              PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	              preparedStatement.setString(1, Global2.s);
	 
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
	Global2.o=gr1.getIdgroup();
	
}



ObservableList<Etudiant>data1=FXCollections.observableArrayList();

try {
	 
	 String sql= "SELECT idencadrant FROM etudiant WHERE idgroup=?"; 
	 Connection con=AdminsDB.getConnection();
	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	 preparedStatement.setInt(1, Global2.o);
	 
     ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data1.add(new Etudiant(rs.getInt(1)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (Etudiant gr1 : data1 )
{
	Global2.f=gr1.getIdencadrant();
	
}
ObservableList<Etudiant>data2=FXCollections.observableArrayList();

List<String> list1 = new ArrayList<String>();
try {
	 
	 String sql= "SELECT nom FROM etudiant WHERE idgroup=?"; 
	 Connection con=AdminsDB.getConnection();
	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	 preparedStatement.setInt(1, Global2.o);
	 
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


		
             Encadrant stu =EtudiantDB.getinfo_e1(Global2.f);
             encadrant.setText(stu.getNom_e());
             nom1.setText(list1.get(0));
             nom2.setText(list1.get(1));
            
	
	}
	
				
			}
			
		);}

         
	
	
	public void champPushed(ActionEvent e) throws IOException{
		
		//Group newProjet = new Group(champ.getText());
		
		//table.getItems().add(newProjet);
		
        String nomProjet = champ.getText();
		
        
		Projets pr=new Projets();
		Group gr=new Group();
		
		pr.setNom(nomProjet);
		gr.setNom(nomProjet);
		
		int status=DBProjet.save(pr);
		int status1=DBGroup.save(gr);
		
		table.getItems().add(gr);
		
		
		/*	if(status>0) {
			
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
*/


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




Task ts=new Task();

ts.setIdgroup(Global2.l);


int status2=DBGroup.savetask(ts);




             Stage primaryStage=new Stage();
             FXMLLoader Loader= new FXMLLoader(getClass().getResource("EtudiantPanel.fxml"));
             Parent root = Loader.load();
             EtudiantPanel con = Loader.getController();
             con.myFunction(nom.getText());


             Scene scene = new Scene(root,605,422);
             scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

             primaryStage.setScene(scene);
             primaryStage.show();




		
		
	}
	
	
	

	private ObservableList<Group> getValue() {
		// TODO Auto-generated method stub
		ObservableList<Group> value=FXCollections.observableArrayList();
		
		try {
			 
			 String sql= "SELECT `idgroup`, `nom` FROM `group` as g JOIN `chef` as c ON g.idchef=c.idchef WHERE g.idchef=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setInt(1,Global1.idchef);
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 value.add(new Group(rs.getInt(1),rs.getString(2)));
				 
			 }
			 con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return value;
	}

	

	
}

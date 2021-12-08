package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ViewStudents implements Initializable{
	

	@FXML
	private TableView<GroupAffichage>table;
	@FXML
	private TableColumn<GroupAffichage,String>group;
	@FXML
    private TabPane tp;

    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
	@FXML
    private JFXTextField nom1;

    @FXML
    private JFXTextField nom2;

    @FXML
    private JFXTextField nom3;

    @FXML
    private JFXTextField nom4;

    @FXML
    private JFXTextField nom11;

    @FXML
    private JFXTextField nom21;

    @FXML
    private JFXTextField nom31;

    @FXML
    private JFXTextField nom41;
   

	
	
	
	
	
	@FXML
	private void show(){
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				List<String> list = new ArrayList<String>();
				
				
				ObservableList<GroupAffichage> selectedRows;
				selectedRows= table.getSelectionModel().getSelectedItems();
				
			    for (GroupAffichage liste:selectedRows )
				{
			    	
			    	
			    	list.add(liste.getGroup());
			    	
			    	
				}
			    String[] parts=list.get(0).split("-");
			    String part1= parts[0];
			    String part2= parts[1];
			   /* 
			    ObservableList<Etudiant>data2=FXCollections.observableArrayList();

			    List<String> list1 = new ArrayList<String>();
			    try {
			    	 
			    	 String sql= "SELECT nom,idgroup FROM etudiant WHERE nom=?"; 
			    	 Connection con=AdminsDB.getConnection();
			    	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			    	 preparedStatement.setString(1, part1);
			    	 
			        ResultSet rs=preparedStatement.executeQuery();
			    	 
			    	 while(rs.next()){
			    		 
			    		 
			    		 data2.add(new Etudiant(rs.getString(1),rs.getInt(2)));
			    		 
			    	 }
			    	 con.close();
			    }catch (SQLException e1) {
			    	e1.printStackTrace();
			    }

			    for (Etudiant liste:data2 )
			    {
			    	
			    	
			    	list1.add(Integer.toString(liste.getIdgroup()));
			    	
			    	
			    }
			    ObservableList<Etudiant>data3=FXCollections.observableArrayList();

			    List<String> list2 = new ArrayList<String>();
			    try {
			    	 
			    	 String sql= "SELECT nom,idetudiant FROM etudiant WHERE nom=?"; 
			    	 Connection con=AdminsDB.getConnection();
			    	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			    	 preparedStatement.setString(1, part2);
			    	 
			        ResultSet rs=preparedStatement.executeQuery();
			    	 
			    	 while(rs.next()){
			    		 
			    		 
			    		 data3.add(new Etudiant(rs.getString(1),rs.getInt(2)));
			    		 
			    	 }
			    	 con.close();
			    }catch (SQLException e1) {
			    	e1.printStackTrace();
			    }

			    for (Etudiant liste:data3 )
			    {
			    	
			    	
			    	list2.add(Integer.toString(liste.getIdgroup()));
			    	
			    	
			    }
			    
			    
			    Global2.id1=Integer.parseInt(list1.get(0));
			    Global2.id2=Integer.parseInt(list2.get(0));
			    */
			    

ObservableList<Etudiant>data4=FXCollections.observableArrayList();

List<String> list4 = new ArrayList<String>();
try {
	 
	 String sql= "SELECT nom,prènom,filière,contact FROM etudiant WHERE nom=?"; 
	 Connection con=AdminsDB.getConnection();
	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	 preparedStatement.setString(1, part1);
	 
    ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data4.add(new Etudiant(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (Etudiant liste:data4 )
{
	
	
	list4.add(liste.getNom());
	list4.add(liste.getPrènom());
	list4.add(liste.getFilière());
	list4.add(liste.getContact());
	
	
}

             nom1.setText(list4.get(0));
             nom2.setText(list4.get(1));
             nom3.setText(list4.get(2));
             nom4.setText(list4.get(3));
            tp.getSelectionModel().select(tab1);

ObservableList<Etudiant>data5=FXCollections.observableArrayList();

List<String> list5 = new ArrayList<String>();
try {
	 
	 String sql= "SELECT nom,prènom,filière,contact FROM etudiant WHERE nom=?"; 
	 Connection con=AdminsDB.getConnection();
	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	 preparedStatement.setString(1, part2);
	 
    ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data5.add(new Etudiant(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (Etudiant liste:data5 )
{
	
	
	list5.add(liste.getNom());
	list5.add(liste.getPrènom());
	list5.add(liste.getFilière());
	list5.add(liste.getContact());
	
	
}

nom11.setText(list5.get(0));
nom21.setText(list5.get(1));
nom31.setText(list5.get(2));
nom41.setText(list5.get(3));
tp.getSelectionModel().select(tab2);


	
			    
			    
			  
			   
			}}
			
				);}
				
				
				
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		group.setCellValueFactory(new PropertyValueFactory<GroupAffichage,String>("group"));
		
		
		table.setItems(getValue());
		table.setEditable(true);
	

	}
	
	private ObservableList<GroupAffichage> getValue() {
		// TODO Auto-generated method stub
		ObservableList<GroupAffichage> value=FXCollections.observableArrayList();
	
      ObservableList<EtudiantBin>data=FXCollections.observableArrayList();

	try {
		 
		 String sql= "SELECT s.idetudiant,s.nom,s.prènom,s.filière,s.contact,s.idgroup FROM `etudiant` as s JOIN `encadrant` as e ON s.idencadrant=e.idencadrant WHERE e.username=? AND e.password=? GROUP BY s.idgroup"; 
		 Connection con=AdminsDB.getConnection();
		 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		 preparedStatement.setString(1,Global1.a);
		 preparedStatement.setString(2,Global1.b);
		 
	     ResultSet rs=preparedStatement.executeQuery();
		 
		 while(rs.next()){
			 
			 
			 data.add(new EtudiantBin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
			 
		 }
		 con.close();
	}catch (SQLException e1) {
		e1.printStackTrace();
	}
	
	for (EtudiantBin gr : data )
	{
    	
	
		System.out.print(gr.getIdgroup());
    	
		ObservableList<Etudiant>data2=FXCollections.observableArrayList();

		List<String> list1 = new ArrayList<String>();
		try {
			 
			 String sql= "SELECT nom FROM etudiant WHERE idgroup=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setInt(1, gr.getIdgroup());
			 
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
		
		
		value.add(new GroupAffichage(list1.get(0)+"-"+list1.get(1)));
    	
	}
	
	return value;
	}
}
	
	
	
 

			
	
	
	
	
	
		
	

	
	
	





















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ViewProgress implements Initializable{
	

	@FXML
	private TableView<GroupAffichage>table;
	@FXML
	private TableColumn<GroupAffichage,String>group;
	@FXML
    private PieChart pie;

    @FXML
    private Label task1;

    @FXML
    private Label task2;

    @FXML
    private Label task3;

    @FXML
    private Label task4;

    @FXML
    private Label task5;

    
   
	
	
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
			    
			    
			    
			    Global1.idgroup2=Integer.parseInt(list1.get(0));
			    
			    List<String> list2 = new ArrayList<String>(0);
				
				ObservableList<Task>data=FXCollections.observableArrayList();

				try {
					 
					 String sql= "SELECT `task1`, `task2`, `task3`, `task4`, `task5` FROM `task` where idgroup=?"; 
					 Connection con=AdminsDB.getConnection();
					 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
					 preparedStatement.setInt(1,Global1.idgroup2);
					 
					 
				     ResultSet rs=preparedStatement.executeQuery();
					 
					 while(rs.next()){
						 
						 
						 data.add(new Task(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
						 
					 }
					 con.close();
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				for (Task gr : data )
				{ 
					
			    	if (gr.getTask1().equals("completed")) {
			    		list2.add(gr.getTask1());
			    	}
			    	if (gr.getTask2().equals("completed")) {
			    		list2.add(gr.getTask2());
			    	}
			    	if (gr.getTask3().equals("completed")) {
			    		list2.add(gr.getTask3());
			    		
			    	}
			    	if (gr.getTask4().equals("completed")) {
			    		list2.add(gr.getTask4());
			    	}
			    	if (gr.getTask5().equals("completed")) {
			    		list2.add(gr.getTask5());
			    	}
			    	
			    	
				}
				
				float n=list2.size();
				float m=(n/5)*100;
				float k=(1-n/5)*100;
				
				ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList(
						new PieChart.Data("Completed Tasks",m),
						new PieChart.Data("Incomplete Tasks", k)
						);
				pie.setData(pieChartData);
				

ObservableList<Task>data4=FXCollections.observableArrayList();

List<String> list4 = new ArrayList<String>();
try {
	 
	 String sql= "SELECT `task1`, `task2`, `task3`, `task4`, `task5` FROM `task` where idgroup=?"; 
	 Connection con=AdminsDB.getConnection();
	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
	 preparedStatement.setInt(1, Global1.idgroup2);
	 
    ResultSet rs=preparedStatement.executeQuery();
	 
	 while(rs.next()){
		 
		 
		 data4.add(new Task(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
		 
	 }
	 con.close();
}catch (SQLException e1) {
	e1.printStackTrace();
}

for (Task liste:data4 )
{
	
	
	list4.add(liste.getTask1());
	list4.add(liste.getTask2());
	list4.add(liste.getTask3());
	list4.add(liste.getTask4());
	list4.add(liste.getTask5());
	
	
}

             task1.setText(list4.get(0));
             task2.setText(list4.get(1));
             task3.setText(list4.get(2));
             task4.setText(list4.get(3));
             task5.setText(list4.get(4));
			    
			    
			    
			    
			    
			    
			    
			  
			   
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
	
	
	
 

			
	
	
	
	
	
		
	

	
	
	





















	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



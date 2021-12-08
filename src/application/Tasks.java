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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Tasks implements Initializable{

	@FXML
    private TableView<Task> table;

  
    @FXML
    private TableColumn<Task,String>task1;
    @FXML
    private TableColumn<Task,String>task2;
    @FXML
    private TableColumn<Task,String>task3;
    @FXML
    private TableColumn<Task,String>task4;
    @FXML
    private TableColumn<Task,String>task5;
    @FXML
	private AnchorPane mainPane;
    @FXML
    private PieChart pie;
    
    
    

    public void refresh(ActionEvent e) throws IOException{
		FxmlLoader object = new FxmlLoader();
		Pane view = object.getPage("Tasks");
		mainPane.getChildren().addAll(view);
		
		
	}
    /*

	@FXML
	private void show(){
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				List<String> list = new ArrayList<String>();
				
				
				ObservableList<Reunion2> selectedRows;
				selectedRows= table.getSelectionModel().getSelectedItems();
				
			    for (Reunion2 liste:selectedRows )
				{
			    	
			    	
			    	list.add(liste.getGroup());
			    	list.add(liste.getDate());
			    	
			    	
			    	
				}
			    String[] parts=list.get(0).split("-");
			    Global2.dateedit=list.get(1);
			    Global2.student1=parts[0];
			    Global2.student2= parts[1];
			    

			    ObservableList<Etudiant>data4=FXCollections.observableArrayList();

			    List<String> list4 = new ArrayList<String>();
			    try {
			    	 
			    	 String sql= "SELECT nom,idgroup FROM etudiant WHERE nom=?"; 
			    	 Connection con=AdminsDB.getConnection();
			    	 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			    	 preparedStatement.setString(1, Global2.student1);
			    	 
			        ResultSet rs=preparedStatement.executeQuery();
			    	 
			    	 while(rs.next()){
			    		 
			    		 
			    		 data4.add(new Etudiant(rs.getString(1),rs.getInt(2)));
			    		 
			    	 }
			    	 con.close();
			    }catch (SQLException e1) {
			    	e1.printStackTrace();
			    }

			    for (Etudiant liste:data4 )
			    {
			    	
			    	
			    	list4.add(Integer.toString(liste.getIdgroup()));
			    	
			    	
			    	
			    }

			                 Global2.idgroup2=Integer.parseInt(list4.get(0));

			}}
		
				);}
				
    

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
*/
    

	
	public void edit(ActionEvent e) throws IOException{
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("EditTask.fxml"));
		
		Scene scene = new Scene(root,605,422);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		task1.setCellValueFactory(new PropertyValueFactory<Task,String>("task1"));
		task2.setCellValueFactory(new PropertyValueFactory<Task,String>("task2"));
		task3.setCellValueFactory(new PropertyValueFactory<Task,String>("task3"));
		task4.setCellValueFactory(new PropertyValueFactory<Task,String>("task4"));
		task5.setCellValueFactory(new PropertyValueFactory<Task,String>("task5"));
		table.setItems(getValue());
		
		List<String> list = new ArrayList<String>(0);
		
		ObservableList<Task>data=FXCollections.observableArrayList();

		try {
			 
			 String sql= "SELECT `task1`, `task2`, `task3`, `task4`, `task5` FROM `task` where idgroup=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setInt(1,Global1.idgroup);
			 
			 
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
	    		list.add(gr.getTask1());
	    	}
	    	if (gr.getTask2().equals("completed")) {
	    		list.add(gr.getTask2());
	    	}
	    	if (gr.getTask3().equals("completed")) {
	    		list.add(gr.getTask3());
	    		
	    	}
	    	if (gr.getTask4().equals("completed")) {
	    		list.add(gr.getTask4());
	    	}
	    	if (gr.getTask5().equals("completed")) {
	    		list.add(gr.getTask5());
	    	}
	    	
	    	
		}
		
		float n=list.size();
		float m=(n/5)*100;
		float k=(1-n/5)*100;
		
		ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList(
				new PieChart.Data("Completed Tasks",m),
				new PieChart.Data("Incomplete Tasks", k)
				);
		pie.setData(pieChartData);
		
		
		
		

	}
	
	
	

	private ObservableList<Task> getValue() {
		// TODO Auto-generated method stub
		
		
		ObservableList<Task> value=FXCollections.observableArrayList();
		
		try {
			 
			 String sql= "SELECT `task1`, `task2`, `task3`, `task4`, `task5` FROM `task` where idgroup=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setInt(1,Global1.idgroup);
		
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 value.add(new Task(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
				 
			 }
			 con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return value;
	}

	

	
}


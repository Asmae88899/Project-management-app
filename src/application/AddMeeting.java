package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddMeeting implements Initializable{
	@FXML
    private JFXTextField time;
	@FXML
    private DatePicker date;
	
	@FXML
    private JFXButton closeButton;
	public void ShowDate(ActionEvent e) throws IOException
	{
		LocalDate ld=date.getValue();
		Global2.date=ld.toString();
		
	}

	public void insertData(ActionEvent e) throws IOException{
        String date = Global2.date+"   "+time.getText();
        
        Reunion1 pr=new Reunion1();
        Reunion2 gr=new Reunion2();
	
		
		pr.setDate(date); 
		gr.setDate(date); 
		gr.setGroup(Global2.group); 
		pr.setIdgroup(Global2.idgroup);
		gr.setIdgroup(Global2.idgroup);
		pr.setIdencadrant(Global1.idencadrant);
		gr.setIdencadrant(Global1.idencadrant);
		
		
	
		
		int status=DBSujetsModifiable.saver1(pr);
		int status1=DBSujetsModifiable.saver2(gr);
		
		ObservableList<Reunion2>data=FXCollections.observableArrayList();

		try {
			 
			 String sql= "SELECT `idreunion2`,`date`, `group`, `idgroup`, `idencadrant` FROM `reunion2` WHERE idgroup=?"; 
			 Connection con=AdminsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 preparedStatement.setInt(1,Global2.idgroup);
			 
			 
		     ResultSet rs=preparedStatement.executeQuery();
			 
			 while(rs.next()){
				 
				 
				 data.add(new Reunion2(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
				 
			 }
			 con.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}

		for (Reunion2 gr1 : data )
		{
			Global2.idreunion2=gr1.getIdreunion2();
			
			
			
			
		}
		StudentModifiable stu = new StudentModifiable();
		stu.setIdreunion2(Global2.idreunion2); 
		
		int status3 = DBGroup.update6(stu);
		Stage stage = (Stage) closeButton.getScene().getWindow();
	    stage.close();

		
		
		
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

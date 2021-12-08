package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DBEncadrantModifiable {
	
	public static Connection getConnection() {
		Connection con= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/projectgestion";
			con=DriverManager.getConnection(url,"Encadrant","Encadrant");
			System.out.println("connected");
		}catch(ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}
	return con;
		
	}
	
	public static EncadrantModifiable getEncadrant(int id) {
		
		EncadrantModifiable stu = new EncadrantModifiable();
		
		try {
			String sql= "SELECT * FROM encadrant  WHERE idencadrant=?";
			Connection con = StudentsDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultSet =preparedStatement.executeQuery();
			
			
			if(resultSet.next()) {
				
				stu.setNom_e(resultSet.getString(1));
				stu.setPrènom_e(resultSet.getString(2));
				stu.setContact_e(resultSet.getString(3));
				
			
			}
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}
	
	
	
	public static int update(EncadrantModifiable stu) {
		int st=0;
		try {
			String sql ="UPDATE encadrant SET `nom`=?,`prènom`=?,`contact`=? WHERE idencadrant=? ";
			Connection con = StudentsDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(4,stu.getIdencadrant());
			preparedStatement.setString(1,stu.getNom_e());
			preparedStatement.setString(2,stu.getPrènom_e());
			preparedStatement.setString(3,stu.getContact_e());
			
			
			st=preparedStatement.executeUpdate();
			con.close();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
			
		
	}
	
	
	
	public static List<EncadrantModifiable> getEncadrant(){
		
		List<EncadrantModifiable>list=new ArrayList<EncadrantModifiable>();
	    
		try {
			 String sql= "SELECT * FROM `encadrant` WHERE 1";
			 Connection con=DBEtudiantModifiable.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 
			 ResultSet resultSet=preparedStatement.executeQuery();
			 
			 
			 while(resultSet.next()){
				 EncadrantModifiable std=new EncadrantModifiable();
				 
				 
				 std.setNom_e(resultSet.getString(1));
				 std.setPrènom_e(resultSet.getString(2));
				 std.setContact_e(resultSet.getString(3));
				 
				 
				 list.add(std);
				 
			 }
			 con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	




	

}


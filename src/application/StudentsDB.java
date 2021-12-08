 package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class StudentsDB {
	
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
	
	public static Students1 getStudents(int id) {
		
		Students1 stu = new Students1();
		
		try {
			String sql= "SELECT * FROM etudiant as e JOIN chef as c ON e.idchef=c.idchef WHERE e.idetudiant=?";
			Connection con = StudentsDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultSet =preparedStatement.executeQuery();
			
			
			if(resultSet.next()) {
				stu.setId(resultSet.getInt(1));
				stu.setNom(resultSet.getString(4));
				stu.setPrènom(resultSet.getString(5));
				stu.setFilière(resultSet.getString(6));
				stu.setContact(resultSet.getString(7));
				
			
			}
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}
	
	
	
	public static int update(Students1 stu) {
		int st=0;
		try {
			String sql ="UPDATE etudiant SET `nom`=?,`prènom`=?,`filière`=?,`contact`=? WHERE idetudiant=? ";
			Connection con = StudentsDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(5,stu.getId());
			preparedStatement.setString(1,stu.getNom());
			preparedStatement.setString(2,stu.getPrènom());
			preparedStatement.setString(3,stu.getFilière());
			preparedStatement.setString(4,stu.getContact());
			
			
			st=preparedStatement.executeUpdate();
			con.close();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
			
		
	}
	
	
	
	public static List<Students1> getStudents(){
		
		List<Students1>list=new ArrayList<Students1>();
	    
		try {
			 String sql= "SELECT * FROM `etudiant` WHERE 1";
			 Connection con=StudentsDB.getConnection();
			 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			 
			 ResultSet resultSet=preparedStatement.executeQuery();
			 
			 
			 while(resultSet.next()){
				 Students1 std=new Students1();
				 
				 std.setId(resultSet.getInt(1));
				 std.setNom(resultSet.getString(2));
				 std.setPrènom(resultSet.getString(3));
				 std.setFilière(resultSet.getString(4));
				 std.setContact(resultSet.getString(5));
				 
				 
				 list.add(std);
				 
			 }
			 con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	




	

}

package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {
	
static Connection con= null;
	
	public static Connection getConnection() {
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
	
	
	
	public static List<Student> getStudent(){
		List<Student> list = new ArrayList<Student>();
		try {
			String sql ="SELECT * FROM etudiant WHERE 1";
			Connection con = StudentDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql); 
			
			ResultSet resultSet =preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Student adm = new Student();
				
				adm.setIdetudiant(resultSet.getInt(1));
				adm.setUsername(resultSet.getString(2));
				adm.setPassword(resultSet.getString(3));
				
				
				list.add(adm);
				
				
			}
			
			con.close();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



}

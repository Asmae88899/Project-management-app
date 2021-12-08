package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BranchDB {
	
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
	
	
	
	public static List<Branch> getBranch(){
		List<Branch> list = new ArrayList<Branch>();
		try {
			String sql ="SELECT * FROM chef WHERE 1";
			Connection con = BranchDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql); 
			
			ResultSet resultSet =preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Branch adm = new Branch();
				
				adm.setIdchef(resultSet.getInt(1));
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
	
	
public static Encadrant getinfo_e(String username,String password) {
		
		Encadrant stu = new Encadrant();
		
		try {
			 
			
			
			//String sql="SELECT e.idencadrant,e.nom,e.prènom,e.contact,r.date FROM encadrant as e JOIN reunion as r ON e.idrèunion=r.idrèunion JOIN etudiant as t ON t.idencadrant=e.idencadrant WHERE e.username=? AND e.password=?";
			Connection con = EtudiantDB.getConnection();
			PreparedStatement prep1 = con.prepareStatement("SELECT e.idencadrant,e.nom,e.prènom,e.contact FROM encadrant as e "); 
			
			prep1.setString(1,username);
			prep1.setString(2,password);
			
			ResultSet resultSet1 =prep1.executeQuery();
			
			
			
			if(resultSet1.next()) {
				stu.setIdencadrant(resultSet1.getInt(1));
				stu.setNom_e(resultSet1.getString(2));
				stu.setPrènom_e(resultSet1.getString(3));
				stu.setContact_e(resultSet1.getString(4));
			}
			
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}

public static List<Encadrant> getAdmins(){
	List<Encadrant> list = new ArrayList<Encadrant>();
	try {
		String sql ="SELECT * FROM encadrant WHERE 1";
		Connection con = EtudiantDB.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql); 
		
		ResultSet resultSet =preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Encadrant adm = new Encadrant();
			adm.setIdencadrant(resultSet.getInt(1));
			
			adm.setNom_e(resultSet.getString(2));
			adm.setPrènom_e(resultSet.getString(3));
			
			
			adm.setContact_e(resultSet.getString(4));
			
			
			
			list.add(adm);
			
			
		}
		
		con.close();
	
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}
	
	
	
	
	
	
	
	
	
	


}

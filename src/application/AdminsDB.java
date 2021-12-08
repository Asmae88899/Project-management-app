package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;

public class AdminsDB {
 
   static Connection con = null;
   public static Connection getConnection(){
        
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost/projectgestion";
				con = DriverManager.getConnection(url,"Encadrant","Encadrant");
				// System.out.println("connected");	
			} catch (ClassNotFoundException |SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                        
		
		
   return con;


   }
   
public static List<Admins> getAdmins(){
	
	List<Admins>list=new ArrayList<Admins>();
    
	try {
		 String sql= "SELECT * FROM `encadrant` WHERE 1";
		 Connection con=AdminsDB.getConnection();
		 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		 
		 ResultSet resultSet=preparedStatement.executeQuery();
		 
		 
		 while(resultSet.next()){
			 Admins adm=new Admins();
			 
			 adm.setId(resultSet.getInt(1));
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

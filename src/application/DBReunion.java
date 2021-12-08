package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DBReunion {
	 
	 
	   public static Connection getConnection(){
		   Connection con = null;
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
	   public static int save(Reunions re) {
		   int mp=0;
		   
		   try {
			   String sql="INSERT INTO `reunion`(`date`) VALUES (?,?,?)";
			   Connection con=DBInfo.getConnection();
			   PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			   preparedStatement.setString(2, re.getDatereunion());
			  
			   mp=preparedStatement.executeUpdate();
			   
			   con.close();
			   
		   }catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   return mp;
             
	   }
	   
	   
public static int update(Reunions re) {
	int mp=0;
	try {String sql="UPDATE `reunion` SET `date`=? WHERE idrèunion=?";
		Connection con=DBInfo.getConnection();
		PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		
		preparedStatement.setString(1, re.getDatereunion());
		preparedStatement.setInt(2, re.getIdgroup());
		
		mp=preparedStatement.executeUpdate();
		   
		   con.close();
		   
	   }catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return mp;
		
		
	}

public static int delete(int id) {
	int mp=0;
	
	try {
		String sql="DELETE FROM `reunion` WHERE idrèunion=?";
		Connection con=DBInfo.getConnection();
		PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		
		mp=preparedStatement.executeUpdate();
		
		
		con.close();
		   
	   }catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return mp;
		
	}

public static Reunions getReunionsId(int id){
	
	Reunions re=new Reunions();
	
	try {
		String sql="SELECT * FROM `reunion` WHERE idrèunion=?";
		Connection con=DBInfo.getConnection();
		PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			
			re.setIdgroup(resultSet.getInt(1)); 
			re.setDatereunion(resultSet.getString(2));
			
		}
		
		
		con.close();
		   
	   }catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return re;
		
	}

public static List<Reunions> getReunions(){
	
	List<Reunions>list=new ArrayList<Reunions>();
    
	try {
		 String sql= "SELECT * FROM `reunion` WHERE 1";
		 Connection con=AdminsDB.getConnection();
		 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		
		 ResultSet resultSet=preparedStatement.executeQuery();
		 
		 
		 while(resultSet.next()){
			 Reunions re=new Reunions();
			 
			 re.setIdgroup(resultSet.getInt(1)); 
			 re.setDatereunion(resultSet.getString(2));
			 
			 list.add(re);
			 
		 }
		 con.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}


/*public static List<Reunions> getReunions1(){
	
	List<Reunions>list=new ArrayList<Reunions>();
    
	try {
		 String sql= "SELECT r.idrèunion, r.date FROM `reunion` as r JOIN `etudiant` as e  ON r.idrèunion=e.idrèunion WHERE e.idgroup=?";
		 Connection con=AdminsDB.getConnection();
		 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		 preparedStatement.setInt(1, Global2.l);
		 
		 ResultSet resultSet=preparedStatement.executeQuery();
		 
		 
		 while(resultSet.next()){
			 Reunions re=new Reunions();
			 
			 re.setIdgroup(resultSet.getInt(1)); 
			 re.setDatereunion(resultSet.getString(2));
			 
			 list.add(re);
			 
		 }
		 con.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}
*/


	













	
		
	
}

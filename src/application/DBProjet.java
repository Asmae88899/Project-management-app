package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DBProjet {
	 
	 
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
	   public static int save(Projets re) {
		   int mp=0;
		   
		   try {
			   String sql="INSERT INTO `projet`(`nom`) VALUES (?)";
			   Connection con=DBInfo.getConnection();
			   PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			   preparedStatement.setString(1, re.getNom());
			  
			   mp=preparedStatement.executeUpdate();
			   
			   con.close();
			   
		   }catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   return mp;
             
	   }
	   
	   
public static int update(Projets re) {
	int mp=0;
	try {String sql="UPDATE `projet` SET `nom`=? WHERE idprojet=?";
		Connection con=DBInfo.getConnection();
		PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		
		preparedStatement.setString(1, re.getNom());
		preparedStatement.setInt(2, re.getIdprojet());
		
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
		String sql="DELETE FROM `projet` WHERE idprojet=?";
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

public static Projets getProjetsId(int id){
	
	Projets re=new Projets();
	
	try {
		String sql="SELECT * FROM `projet` WHERE idprojet=?";
		Connection con=DBInfo.getConnection();
		PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			
			re.setIdprojet(resultSet.getInt(1)); 
			re.setNom(resultSet.getString(2));
			
		}
		
		
		con.close();
		   
	   }catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return re;
		
	}

public static List<Projets> getReunions(){
	
	List<Projets>list=new ArrayList<Projets>();
    
	try {
		 String sql= "SELECT * FROM `projet` WHERE 1";
		 Connection con=AdminsDB.getConnection();
		 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		 
		 ResultSet resultSet=preparedStatement.executeQuery();
		 
		 
		 while(resultSet.next()){
			 Projets re=new Projets();
			 
			 re.setIdprojet(resultSet.getInt(1)); 
			 re.setNom(resultSet.getString(2));
			 
			 list.add(re);
			 
		 }
		 con.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}


	













	
		
	
}

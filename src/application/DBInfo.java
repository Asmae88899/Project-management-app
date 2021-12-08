package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DBInfo {
	 
	 
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
	   public static int save(Students std) {
		   int mp=0;
		   
		   try {
			   String sql="INSERT INTO `etudiant`(`nom`, `prènom`, `contact`, `filière`) VALUES (?,?,?,?)";
			   Connection con=DBInfo.getConnection();
			   PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			   preparedStatement.setString(1, std.getNom());
			   preparedStatement.setString(2, std.getPrenom());
			   preparedStatement.setString(3, std.getGmail());
			   preparedStatement.setString(4, std.getFiliere());
			   
			   mp=preparedStatement.executeUpdate();
			   
			   con.close();
			   
		   }catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   return mp;
             
	   }
	   
	   
	   /*public static int update(Students std) {
	int mp=0;
	try {
		String sql="UPDATE `students` SET `date`=? WHERE id=?";
		Connection con=DBInfo.getConnection();
		PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		
		preparedStatement.setString(1, std.getDate());
		preparedStatement.setInt(2, std.getId());
		
		mp=preparedStatement.executeUpdate();
		   
		   con.close();
		   
	   }catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return mp;
		
		
	}*/

/*public static int delete(int id) {
	int mp=0;
	
	try {
		String sql="DELETE FROM `students` WHERE id=?";
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
		
	}*/

public static Students getStudentsId(int id){
	
	Students std=new Students();
	
	try {
		String sql="SELECT * FROM `etudiant` WHERE idetudiant=?";
		Connection con=DBInfo.getConnection();
		PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			
			std.setIdgroup(resultSet.getInt(1));
			std.setNom(resultSet.getString(2));
			std.setPrenom(resultSet.getString(3));
			std.setGmail(resultSet.getString(4));
			std.setFiliere(resultSet.getString(5));
			
			
		}
		
		
		con.close();
		   
	   }catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return std;
		
	}

public static List<Students> getStudents(){
	
	List<Students>list=new ArrayList<Students>();
    
	try {
		 String sql= "SELECT * FROM `etudiant` WHERE 1";
		 Connection con=AdminsDB.getConnection();
		 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
		 
		 ResultSet resultSet=preparedStatement.executeQuery();
		 
		 
		 while(resultSet.next()){
			 Students std=new Students();
			 
			 std.setIdgroup(resultSet.getInt(1));
			 std.setNom(resultSet.getString(2));
			 std.setPrenom(resultSet.getString(3));
			 std.setGmail(resultSet.getString(4));
			 std.setFiliere(resultSet.getString(5));
			 
			 
			 list.add(std);
			 
		 }
		 con.close();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}


	













	
		
	
}
	 
	   
	   

	   
	   
	   
	   
	   
	   
	   
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   


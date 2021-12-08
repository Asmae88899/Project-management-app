package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBSujetsModifiable {
	 
	 
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
	   
	   
	   
	   public static int save(SujetModifiable re) {
		   int mp=0;
		   
		   try {
			   String sql="INSERT INTO `sujet`( `nom`, `document`, `description`, `idencadrant`) VALUES (?,?,?,?)";
			   Connection con=DBInfo.getConnection();
			   PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			   
			   preparedStatement.setString(1, re.getNom_s());
			   preparedStatement.setString(2, re.getDocument_s());
			   preparedStatement.setString(3, re.getDescription());
			   preparedStatement.setInt(4, Global1.idencadrant);
			   mp=preparedStatement.executeUpdate();
			   
			   con.close();
			   
		   }catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   return mp;
             
	   }
	   public static List<SujetModifiable> getSujetModifiable(){
			
			List<SujetModifiable>list=new ArrayList<SujetModifiable>();
		    
			try {
				 String sql= "SELECT * FROM `sujet` WHERE 1";
				 Connection con=AdminsDB.getConnection();
				 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				 
				 ResultSet resultSet=preparedStatement.executeQuery();
				 
				 
				 while(resultSet.next()){
					 SujetModifiable re=new SujetModifiable();
					 
					 re.setIdsujet(resultSet.getInt(1)); 
					 
					 re.setNom_s(resultSet.getString(2)); 
					 re.setDocument_s(resultSet.getString(3));
					 re.setDescription(resultSet.getString(4));
					 
					 list.add(re);
					 
				 }
				 con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	   
	   
	   public static int update(SujetModifiable re) {
			int mp=0;
			try {String sql="UPDATE `etudiant` SET `idsujet`=? WHERE idetudiant=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.p);
				preparedStatement.setInt(2, Global2.x);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}
	   
	   
	   public static int update1(SujetModifiable re) {
			int mp=0;
			try {String sql="UPDATE `etudiant` SET `idsujet`=? WHERE idetudiant=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.p);
				preparedStatement.setInt(2, Global2.y);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}
	   
	/*   public static int update2(StudentsModifiable re) {
			int mp=0;
			try {String sql="UPDATE `etudiant` SET `idencadrant`=? WHERE idgroup=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.k);
				preparedStatement.setInt(2, Global2.l);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}
	   public static int update3(Reunions re) {
			int mp=0;
			try {String sql="UPDATE `reunion` SET `idgroup`=? WHERE idencadrant=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.l);
				preparedStatement.setInt(2, Global2.k);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}*/
	   
	   public static int saver2(Reunion2 re) {
		   int mp=0;
		   
		   try {
			   String sql="INSERT INTO `reunion2`( `date`, `idencadrant`, `group`, `idgroup`) VALUES (?,?,?,?)";
			   Connection con=DBInfo.getConnection();
			   PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			   
			   preparedStatement.setString(1, re.getDate());
			   preparedStatement.setInt(2, re.getIdencadrant());
			   preparedStatement.setString(3, re.getGroup());
			   preparedStatement.setInt(4, re.getIdgroup());
			   mp=preparedStatement.executeUpdate();
			   
			   con.close();
			   
		   }catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   return mp;
             
	   }
	   
	   public static int saver1(Reunion1 re) {
		   int mp=0;
		   
		   try {
			   String sql="INSERT INTO `reunion1`( `date`, `idencadrant`,`idgroup`) VALUES (?,?,?)";
			   Connection con=DBInfo.getConnection();
			   PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
			   
			   preparedStatement.setString(1, re.getDate());
			   preparedStatement.setInt(2, re.getIdencadrant());
			
			   preparedStatement.setInt(3, re.getIdgroup());
			   mp=preparedStatement.executeUpdate();
			   
			   con.close();
			   
		   }catch(SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   return mp;
             
	   }
	   
}
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBGroup {
	 
	 
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
	   
	   
	   
	   public static int save(Group re) {
		   int mp=0;
		   
		   try {
			   String sql="INSERT INTO `group`(`nom`) VALUES (?)";
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
	   public static List<Group> getGroup(){
			
			List<Group>list=new ArrayList<Group>();
		    
			try {
				 String sql= "SELECT * FROM `group` WHERE 1";
				 Connection con=AdminsDB.getConnection();
				 PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				 
				 ResultSet resultSet=preparedStatement.executeQuery();
				 
				 
				 while(resultSet.next()){
					 Group re=new Group();
					 
					 re.setIdgroup(resultSet.getInt(1)); 
					 
					 re.setNom(resultSet.getString(2));
					
					 
					 list.add(re);
					 
				 }
				 con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	   
	   
	   public static int update(Group re) {
			int mp=0;
			try {String sql="UPDATE `etudiant` SET `idgroup`=? WHERE idetudiant=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.l);
				preparedStatement.setInt(2, Global2.x);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}
	   
	   
	   public static int update1(Group re) {
			int mp=0;
			try {String sql="UPDATE `etudiant` SET `idgroup`=? WHERE idetudiant=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.l);
				preparedStatement.setInt(2, Global2.y);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}
	   
	   public static int update2(StudentsModifiable re) {
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
				
				
			}
	   
	   
	   public static int update4(StudentModifiable re) {
			int mp=0;
			try {String sql="UPDATE `etudiant` SET `idsujet`=? WHERE idgroup=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.p);
				preparedStatement.setInt(2, Global2.h);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}
	   public static int update6(StudentModifiable re) {
			int mp=0;
			try {String sql="UPDATE `etudiant` SET `idreunion2`=? WHERE idgroup=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.idreunion2);
				preparedStatement.setInt(2, Global2.idgroup);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}
	   
	   
	 /*  public static int update3(StudentsModifiable re) {
			int mp=0;
			try {String sql="UPDATE `etudiant` SET `idencadrant`=? WHERE nomGROUP=?";
				Connection con=DBInfo.getConnection();
				PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				
				preparedStatement.setInt(1, Global2.l);
				preparedStatement.setString(2, Global2.d);
				
				
				mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
				
				
			}*/

	 	public static int updater(Reunion1 stu) {
			int st=0;
			try {
				String sql ="UPDATE `reunion1` SET `student1`=?,`student2`=? WHERE date=? AND idencadrant=?";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
				
				
				preparedStatement.setString(1,stu.getStudent1());
				preparedStatement.setString(2,stu.getStudent2());
				preparedStatement.setString(3,stu.getDate());
				preparedStatement.setInt(4,stu.getIdencadrant());
				
				
				st=preparedStatement.executeUpdate();
				con.close();
				
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return st;
				
			
		}
	 	
	 	public static int updater2(Reunion2 stu) {
			int st=0;
			try {
				String sql ="UPDATE `reunion2` SET `date`=? WHERE idgroup=? AND idencadrant=?";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
				
				
				preparedStatement.setString(1,stu.getDate());
				preparedStatement.setInt(2,stu.getIdgroup());
				preparedStatement.setInt(3,Global1.idencadrant);
				
				
				
				st=preparedStatement.executeUpdate();
				con.close();
				
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return st;
				
			
		}
	 	
	 	public static int updatetask(Task stu) {
			int st=0;
			try {
				String sql ="UPDATE `task` SET `task1`=?,`task2`=?, `task3`=? ,`task4`=? ,`task5`=? WHERE idgroup=? ";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
				
				
				preparedStatement.setString(1,stu.getTask1());
				preparedStatement.setString(2,stu.getTask2());
				preparedStatement.setString(3,stu.getTask3());
				preparedStatement.setString(4,stu.getTask4());
				preparedStatement.setString(5,stu.getTask5());
				preparedStatement.setInt(6,Global1.idgroup);
			
				
				
				
				st=preparedStatement.executeUpdate();
				con.close();
				
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return st;
				
			
		}
	 	
	 	public static Task getinfotask(int idgroup) {
			
			Task stu = new Task();
			
			try {
				String sql= "SELECT task1,task2,task3,task4,task5 FROM task WHERE idgroup=?";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
				preparedStatement.setInt(1,idgroup);
			
				ResultSet resultSet =preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					stu.setTask1(resultSet.getString(1));
					stu.setTask2(resultSet.getString(2));
					stu.setTask3(resultSet.getString(3));
					stu.setTask4(resultSet.getString(4));
					stu.setTask5(resultSet.getString(5));
					
				
				}
				
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return stu;
			
		}
	 	
	 	public static int savetask(Task re) {
			   int mp=0;
			   
			   try {
				   String sql="INSERT INTO `task`(`idgroup`) VALUES (?)";
				   Connection con=DBInfo.getConnection();
				   PreparedStatement preparedStatement=(PreparedStatement)con.prepareStatement(sql);
				   preparedStatement.setInt(1, re.getIdgroup());
				  
				   mp=preparedStatement.executeUpdate();
				   
				   con.close();
				   
			   }catch(SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   return mp;
	             
		   }



			













			
				
			
		}
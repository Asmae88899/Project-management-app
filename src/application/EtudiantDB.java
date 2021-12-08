package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDB {
	
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
	public static Etudiant getinfo(String username,String password) {
		
		Etudiant stu = new Etudiant();
		
		try {
			String sql= "SELECT idetudiant,nom,prènom,filière,contact FROM etudiant WHERE username=? AND password=?";
			Connection con = EtudiantDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			ResultSet resultSet =preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				stu.setId(resultSet.getInt(1));
				stu.setNom(resultSet.getString(2));
				stu.setPrènom(resultSet.getString(3));
				stu.setFilière(resultSet.getString(4));
				stu.setContact(resultSet.getString(5));
				
			
			}
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}
public static Etudiant getinfob(int id,String username) {
		
		Etudiant stu = new Etudiant();
		
		try {
			String sql= "SELECT idetudiant,nom,prènom,filière,contact FROM etudiant WHERE idgroup=? AND username not like ?";
			Connection con = EtudiantDB.getConnection();
			PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,username);
			ResultSet resultSet =preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				stu.setId(resultSet.getInt(1));
				stu.setNom(resultSet.getString(2));
				stu.setPrènom(resultSet.getString(3));
				stu.setFilière(resultSet.getString(4));
				stu.setContact(resultSet.getString(5));
				
			
			}
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}
	
	
	
	public static Encadrant getinfo_e(String username,String password) {
		
		Encadrant stu = new Encadrant();
		
		try {
			 
			
			
			//String sql="SELECT e.idencadrant,e.nom,e.prènom,e.contact,r.date FROM encadrant as e JOIN reunion as r ON e.idrèunion=r.idrèunion JOIN etudiant as t ON t.idencadrant=e.idencadrant WHERE e.username=? AND e.password=?";
			Connection con = EtudiantDB.getConnection();
			PreparedStatement prep1 = con.prepareStatement("SELECT e.idencadrant,e.nom,e.prènom,e.contact FROM etudiant as t JOIN encadrant as e ON t.idencadrant=e.idencadrant WHERE t.username=? AND t.password=?"); 
			//	PreparedStatement prep2 = con.prepareStatement("SELECT r.date FROM reunion as r JOIN etudiant as t ON r.idrèunion=t.idrèunion WHERE t.username=? AND t.password=?"); 
			prep1.setString(1,username);
			prep1.setString(2,password);
			//prep2.setString(1,username);
			//prep2.setString(2,password);
			ResultSet resultSet1 =prep1.executeQuery();
			//ResultSet resultSet2 =prep2.executeQuery();
			
			
			if(resultSet1.next()) {
				stu.setIdencadrant(resultSet1.getInt(1));
				stu.setNom_e(resultSet1.getString(2));
				stu.setPrènom_e(resultSet1.getString(3));
				stu.setContact_e(resultSet1.getString(4));
			}
			//if(resultSet2.next()) {
			//	stu.setDate_e(resultSet2.getString(1));
			//}
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}
	
	

	/*public static Binome getinfo_b(int id,String username) {
		
		Binome stu = new Binome();
		
		try {
			
			
			
			//String sql="SELECT e.idencadrant,e.nom,e.prènom,e.contact,r.date FROM encadrant as e JOIN reunion as r ON e.idrèunion=r.idrèunion JOIN etudiant as t ON t.idencadrant=e.idencadrant WHERE e.username=? AND e.password=?";
			Connection con = EtudiantDB.getConnection();
			PreparedStatement prep1 = con.prepareStatement("SELECT idetudiant,nom,prènom,filière,contact FROM etudiant WHERE idgroup=? AND username not like '%?%'"); 
			prep1.setInt(1,id);
			prep1.setString(2,username);
			ResultSet resultSet1 =prep1.executeQuery();
			
			
			
			if(resultSet1.next()) {
				stu.setIdbinome(resultSet1.getInt(1));
				stu.setNom_b(resultSet1.getString(2));
				stu.setPrènom_b(resultSet1.getString(3));
				stu.setFilière_b(resultSet1.getString(4));
				stu.setContact_b(resultSet1.getString(5));
			}
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}*/
	
	
	
	public static Sujet getinfo_s(String username,String password) {
		
		Sujet stu = new Sujet();
		
		try {
			 
			
			
			//String sql="SELECT e.idencadrant,e.nom,e.prènom,e.contact,r.date FROM encadrant as e JOIN reunion as r ON e.idrèunion=r.idrèunion JOIN etudiant as t ON t.idencadrant=e.idencadrant WHERE e.username=? AND e.password=?";
			Connection con = EtudiantDB.getConnection();
			PreparedStatement prep1 = con.prepareStatement("SELECT s.idsujet,s.nom,s.document,s.description FROM sujet as s JOIN etudiant as e ON s.idsujet=e.idsujet WHERE e.username=? AND e.password=?"); 
			prep1.setString(1,username);
			prep1.setString(2,password);
			ResultSet resultSet1 =prep1.executeQuery();
			
			
			
			if(resultSet1.next()) {
				stu.setIdsujet(resultSet1.getInt(1));
				stu.setNom_s(resultSet1.getString(2));
				stu.setDocument_s(resultSet1.getString(3));
				stu.setDescription(resultSet1.getString(4));
			}
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}
	
	
	
	
	
	
	
	public static Soutenance getinfo_so(String username,String password) {
		
		Soutenance stu = new Soutenance();
		
		try {
			 
			
			
			//String sql="SELECT e.idencadrant,e.nom,e.prènom,e.contact,r.date FROM encadrant as e JOIN reunion as r ON e.idrèunion=r.idrèunion JOIN etudiant as t ON t.idencadrant=e.idencadrant WHERE e.username=? AND e.password=?";
			Connection con = EtudiantDB.getConnection();
			PreparedStatement prep1 = con.prepareStatement("SELECT s.idsoutenance,s.numsalle,s.datesoutenance FROM soutenance as s JOIN etudiant as e ON s.idsoutenance=e.idsoutenance WHERE e.username=? AND e.password=?"); 
			prep1.setString(1,username);
			prep1.setString(2,password);
			ResultSet resultSet1 =prep1.executeQuery();
			
			
			
			if(resultSet1.next()) {
				stu.setIdsoutenance(resultSet1.getInt(1));
				stu.setNumsalle(resultSet1.getInt(2));
				stu.setDatesou(resultSet1.getString(3));
				
			}
			
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stu;
		
	}
	
	 
	 
	 	public static int update(Etudiant stu) {
			int st=0;
			try {
				String sql ="UPDATE `etudiant` SET `nom`=?,`prènom`=?,`filière`=?,`contact`=? WHERE username=? AND password=?";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
				
				
				preparedStatement.setString(5,stu.getUsername());
				preparedStatement.setString(6,stu.getPassword());
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
	 
	 
	 public static List<Etudiant> getAdmins(){
			List<Etudiant> list = new ArrayList<Etudiant>();
			try {
				String sql ="SELECT * FROM etudiant WHERE 1";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql); 
				
				ResultSet resultSet =preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Etudiant adm = new Etudiant();
					adm.setId(resultSet.getInt(1));
					adm.setUsername(resultSet.getString(2));
					adm.setPassword(resultSet.getString(3));
					adm.setNom(resultSet.getString(4));
					adm.setPrènom(resultSet.getString(5));
					adm.setFilière(resultSet.getString(6));
					
					adm.setContact(resultSet.getString(7));
					
					
					
					list.add(adm);
					
					
				}
				
				con.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	 public static List<EtudiantBin> getAdminsBin(){
			List<EtudiantBin> list = new ArrayList<EtudiantBin>();
			try {
				String sql ="SELECT * FROM etudiant WHERE 1";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql); 
				
				ResultSet resultSet =preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					EtudiantBin adm = new EtudiantBin();
					adm.setId(resultSet.getInt(1));
					adm.setUsername(resultSet.getString(2));
					adm.setPassword(resultSet.getString(3));
					adm.setNom(resultSet.getString(4));
					adm.setPrènom(resultSet.getString(5));
					adm.setFilière(resultSet.getString(6));
					
					adm.setContact(resultSet.getString(7));
					adm.setIdgroup(resultSet.getInt(8));
					
					
					
					list.add(adm);
					
					
				}
				
				con.close();
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	 
	 
	 public static Etudiant getinfo1(String username,String password) {
			
			Etudiant stu = new Etudiant();
			
			try {
				String sql= "SELECT idencadrant FROM etudiant WHERE username=? AND password=?";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement preparedStatement = (PreparedStatement)con.prepareStatement(sql);
				preparedStatement.setString(1,username);
				preparedStatement.setString(2,password);
				ResultSet resultSet =preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					stu.setId(resultSet.getInt(1));
					
				
				}
				
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return stu;
			
		}
	 
	 public static Encadrant getinfo_e1(int idencadrant) {
			
			Encadrant stu = new Encadrant();
			
			try {
				 
				
				
				//String sql="SELECT e.idencadrant,e.nom,e.prènom,e.contact,r.date FROM encadrant as e JOIN reunion as r ON e.idrèunion=r.idrèunion JOIN etudiant as t ON t.idencadrant=e.idencadrant WHERE e.username=? AND e.password=?";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement prep1 = con.prepareStatement("SELECT nom  FROM  encadrant WHERE idencadrant=? "); 
				
				prep1.setInt(1,idencadrant);
				
				ResultSet resultSet1 =prep1.executeQuery();
			
				
				if(resultSet1.next()) {
					
					stu.setNom_e(resultSet1.getString(1));
					
				}
				
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return stu;
			
		}
	 
	 
	 public static Reunion2 getinfo_r(String username,String password) {
			
		 Reunion2 stu = new Reunion2();
			
			try {
				 
				
				
				//String sql="SELECT e.idencadrant,e.nom,e.prènom,e.contact,r.date FROM encadrant as e JOIN reunion as r ON e.idrèunion=r.idrèunion JOIN etudiant as t ON t.idencadrant=e.idencadrant WHERE e.username=? AND e.password=?";
				Connection con = EtudiantDB.getConnection();
				PreparedStatement prep1 = con.prepareStatement("SELECT r.idreunion2,r.date FROM reunion2 as r JOIN etudiant as e ON r.idreunion2=e.idreunion2 WHERE e.username=? AND e.password=?"); 
				prep1.setString(1,username);
				prep1.setString(2,password);
				ResultSet resultSet1 =prep1.executeQuery();
				
				
				
				if(resultSet1.next()) {
					stu.setIdreunion2(resultSet1.getInt(1));
					stu.setDate(resultSet1.getString(2));
					
					
				}
				
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return stu;
			
		}
		


}

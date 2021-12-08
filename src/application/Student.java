package application;

public class Student {
	private int idetudiant;
	private String username;
	private String password;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int idetudiant, String username, String password) {
		super();
		this.idetudiant = idetudiant;
		this.username = username;
		this.password = password;
	}
	public int getIdetudiant() {
		return idetudiant;
	}
	public void setIdetudiant(int idetudiant) {
		this.idetudiant = idetudiant;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

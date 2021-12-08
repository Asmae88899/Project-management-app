package application;

public class Branch {
	
	private int idchef;
	private String username;
	private String password;
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Branch(int idchef, String username, String password) {
		super();
		this.idchef = idchef;
		this.username = username;
		this.password = password;
	}
	
	public Branch(int idchef) {
		super();
		this.idchef = idchef;
		
	}
	public int getIdchef() {
		return idchef;
	}
	public void setIdchef(int idchef) {
		this.idchef = idchef;
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

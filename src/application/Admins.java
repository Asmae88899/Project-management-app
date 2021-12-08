package application;

public class Admins {
	
	private int id;
	private String username;
	private String password;
	
	
	public Admins() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admins(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Admins(int id) {
		super();
		this.id = id;
		
	}



	public Admins(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public final int getId() {
		return id;
	}


	public final void setId(int id) {
		this.id = id;
	}


	public final String getUsername() {
		return username;
	}


	public final void setUsername(String username) {
		this.username = username;
	}


	public final String getPassword() {
		return password;
	}


	public final void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}

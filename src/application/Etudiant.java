package application;

public class Etudiant {
	
	private String username;
	private String password;
	private int id;
	private String nom;
	private String pr�nom;
	private String fili�re;
	private String contact;
	private int idgroup;
	private int idencadrant;
	private int idreunion2;
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etudiant(String username, String password, int id, String nom, String pr�nom, String fili�re,
			String contact) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.fili�re = fili�re;
		this.contact = contact;
	}
	public Etudiant( int idgroup,String nom, String pr�nom, String fili�re,
			String contact) {
		super();
		this.idgroup=idgroup;
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.fili�re = fili�re;
		this.contact = contact;
	}
	public Etudiant( String nom, String pr�nom, String fili�re,
			String contact) {
		super();
		
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.fili�re = fili�re;
		this.contact = contact;
	}
	
	public Etudiant( int idencadrant) {
		super();
		
		this.idencadrant = idencadrant;
		
	}
	public Etudiant( int idreunion2,String nom) {
		super();
		
		this.idreunion2 = idreunion2;
		this.nom = nom;
		
	}
	public Etudiant( String nom) {
		super();
		
		this.nom= nom;
		
	}
	public Etudiant( String nom,int idgroup) {
		super();
		this.nom= nom;
		this.idgroup= idgroup;
		
	}
	
	
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPr�nom() {
		return pr�nom;
	}
	public void setPr�nom(String pr�nom) {
		this.pr�nom = pr�nom;
	}
	public String getFili�re() {
		return fili�re;
	}
	public void setFili�re(String fili�re) {
		this.fili�re = fili�re;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getIdencadrant() {
		return idencadrant;
	}
	public void setIdencadrant(int idencadrant) {
		this.idencadrant = idencadrant;
	}
	public int getIdreunion2() {
		return idreunion2;
	}
	public void setIdreunion2(int idreunion2) {
		this.idreunion2 = idreunion2;
	}
	
	

}

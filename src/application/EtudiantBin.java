package application;

public class EtudiantBin {
	
	private String username;
	private String password;
	private int id;
	private String nom;
	private String pr�nom;
	private String fili�re;
	private String contact;
	private int idgroup;
	public EtudiantBin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EtudiantBin( int id, String nom, String pr�nom, String fili�re,
			String contact,int idgroup) {
		super();
	
		this.id = id;
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.fili�re = fili�re;
		this.contact = contact;
		this.idgroup= idgroup;
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
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	

}

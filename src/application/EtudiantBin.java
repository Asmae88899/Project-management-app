package application;

public class EtudiantBin {
	
	private String username;
	private String password;
	private int id;
	private String nom;
	private String prènom;
	private String filière;
	private String contact;
	private int idgroup;
	public EtudiantBin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EtudiantBin( int id, String nom, String prènom, String filière,
			String contact,int idgroup) {
		super();
	
		this.id = id;
		this.nom = nom;
		this.prènom = prènom;
		this.filière = filière;
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
	public String getPrènom() {
		return prènom;
	}
	public void setPrènom(String prènom) {
		this.prènom = prènom;
	}
	public String getFilière() {
		return filière;
	}
	public void setFilière(String filière) {
		this.filière = filière;
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

package application;

public class Encadrant {
	
	private int idencadrant;
	private String nom_e;
	private String pr�nom_e;
	private String contact_e;
	private String date_e;
	public Encadrant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Encadrant(int idencadrant, String nom_e, String pr�nom_e, String contact_e, String date_e) {
		super();
		this.idencadrant = idencadrant;
		this.nom_e = nom_e;
		this.pr�nom_e = pr�nom_e;
		this.contact_e = contact_e;
		this.date_e = date_e;
	}
	
	public Encadrant(int idencadrant, String nom_e, String pr�nom_e, String contact_e) {
		super();
		this.idencadrant = idencadrant;
		this.nom_e = nom_e;
		this.pr�nom_e = pr�nom_e;
		this.contact_e = contact_e;
		
	}
	
	public int getIdencadrant() {
		return idencadrant;
	}
	public void setIdencadrant(int idencadrant) {
		this.idencadrant = idencadrant;
	}
	public String getNom_e() {
		return nom_e;
	}
	public void setNom_e(String nom_e) {
		this.nom_e = nom_e;
	}
	public String getPr�nom_e() {
		return pr�nom_e;
	}
	public void setPr�nom_e(String pr�nom_e) {
		this.pr�nom_e = pr�nom_e;
	}
	public String getContact_e() {
		return contact_e;
	}
	public void setContact_e(String contact_e) {
		this.contact_e = contact_e;
	}
	public String getDate_e() {
		return date_e;
	}
	public void setDate_e(String date_e) {
		this.date_e = date_e;
	}
	
	
	
	
}

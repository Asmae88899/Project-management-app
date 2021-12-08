package application;

public class Binome {
	private int idbinome;
	private String nom_b;
	private String prènom_b;
	private String filière_b;
	private String contact_b;
	public Binome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Binome(int idbinome, String nom_b, String prènom_b, String filière_b, String contact_b) {
		super();
		this.idbinome = idbinome;
		this.nom_b = nom_b;
		this.prènom_b = prènom_b;
		this.filière_b = filière_b;
		this.contact_b = contact_b;
	}
	public int getIdbinome() {
		return idbinome;
	}
	public void setIdbinome(int idbinome) {
		this.idbinome = idbinome;
	}
	public String getNom_b() {
		return nom_b;
	}
	public void setNom_b(String nom_b) {
		this.nom_b = nom_b;
	}
	public String getPrènom_b() {
		return prènom_b;
	}
	public void setPrènom_b(String prènom_b) {
		this.prènom_b = prènom_b;
	}
	public String getFilière_b() {
		return filière_b;
	}
	public void setFilière_b(String filière_b) {
		this.filière_b = filière_b;
	}
	public String getContact_b() {
		return contact_b;
	}
	public void setContact_b(String contact_b) {
		this.contact_b = contact_b;
	}
	
	
}

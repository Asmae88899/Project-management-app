package application;

public class Sujet {
	
	private int idsujet;
	private String nom_s;
	private String document_s;
	private String description;
	public Sujet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sujet(int idsujet, String nom_s, String document_s) {
		super();
		this.idsujet = idsujet;
		this.nom_s = nom_s;
		this.document_s = document_s;
	}
	public Sujet(int idsujet, String nom_s, String document_s,String description) {
		super();
		this.idsujet = idsujet;
		this.nom_s = nom_s;
		this.document_s = document_s;
		this.description = description;
	}
	public int getIdsujet() {
		return idsujet;
	}
	public void setIdsujet(int idsujet) {
		this.idsujet = idsujet;
	}
	public String getNom_s() {
		return nom_s;
	}
	public void setNom_s(String nom_s) {
		this.nom_s = nom_s;
	}
	public String getDocument_s() {
		return document_s;
	}
	public void setDocument_s(String document_s) {
		this.document_s = document_s;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}

package application;

public class Group {
	private int idgroup;
	private String nom;
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(int idgroup, String nom) {
		super();
		this.idgroup=idgroup;
	
		this.nom = nom;
	}
	public int getIdgroup() {
		return idgroup;
	}
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

	
	
	

}

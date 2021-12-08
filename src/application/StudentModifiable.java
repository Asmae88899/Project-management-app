package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentModifiable {

	private SimpleIntegerProperty id;
	private SimpleStringProperty username;
	private SimpleStringProperty password;
	private SimpleStringProperty nom;
	private SimpleStringProperty pr�nom;
	private SimpleStringProperty fili�re;
	private SimpleStringProperty contact;
	private SimpleIntegerProperty idbinome;
	private SimpleIntegerProperty idencadtant;
	private SimpleIntegerProperty idreunion2;
	private SimpleIntegerProperty idsujet;
	private SimpleIntegerProperty idsoutenance;
	private SimpleIntegerProperty idgroup;
	public StudentModifiable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentModifiable(int id, String nom, String pr�nom,
			String fili�re, String contact, int idgroup) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.nom = new SimpleStringProperty(nom);
		this.pr�nom = new SimpleStringProperty(pr�nom);
		this.fili�re = new SimpleStringProperty(fili�re);
		this.contact = new SimpleStringProperty(contact);
		this.idgroup= new SimpleIntegerProperty(idgroup);
	}
	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}
	public String getUsername() {
		return username.get();
	}
	public void setUsername(String username) {
		this.username = new SimpleStringProperty(username);
	}
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String password) {
		this.password =  new SimpleStringProperty(password);
	}
	public String getNom() {
		return nom.get();
	}
	public void setNom(String nom) {
		this.nom =  new SimpleStringProperty(nom) ;
	}
	public String getPr�nom() {
		return pr�nom.get();
	}
	public void setPr�nom(String pr�nom) {
		this.pr�nom =  new SimpleStringProperty(pr�nom) ;
	}
	public String getFili�re() {
		return fili�re.get();
	}
	public void setFili�re(String fili�re) {
		this.fili�re =  new SimpleStringProperty(fili�re);
	}
	public String getContact() {
		return contact.get();
	}
	public void setContact(String contact) {
		this.contact =  new SimpleStringProperty(contact);
	}
	public SimpleIntegerProperty getIdbinome() {
		return idbinome;
	}
	public void setIdbinome(SimpleIntegerProperty idbinome) {
		this.idbinome = idbinome;
	}
	public int getIdencadtant() {
		return idencadtant.get();
	}
	public void setIdencadtant(int idencadtant) {
		this.idencadtant =new SimpleIntegerProperty(idencadtant);
	}
	public int getIdreunion2() {
		return idreunion2.get();
	}
	public void setIdreunion2(int idreunion2) {
		this.idreunion2 = new SimpleIntegerProperty(idreunion2);
	}
	public int getIdsujet() {
		return idsujet.get();
	}
	public void setIdsujet(int idsujet) {
		this.idsujet = new SimpleIntegerProperty(idsujet);
	}
	public SimpleIntegerProperty getIdsoutenance() {
		return idsoutenance;
	}
	public void setIdsoutenance(SimpleIntegerProperty idsoutenance) {
		this.idsoutenance = idsoutenance;
	}
	public int getIdgroup() {
		return idgroup.get();
	}
	public void setIdgroup(int id) {
		this.idgroup = new SimpleIntegerProperty(id);
	}
	
	
	

}

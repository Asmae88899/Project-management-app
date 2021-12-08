package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EncadrantModifiable {
	private SimpleIntegerProperty idencadrant;
	private SimpleStringProperty nom_e;
	private SimpleStringProperty prènom_e;
	private SimpleStringProperty contact_e;
	public EncadrantModifiable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EncadrantModifiable(int idencadrant, String nom_e, String prènom_e,
			String contact_e) {
		super();
		this.idencadrant = new SimpleIntegerProperty(idencadrant);
		this.nom_e = new SimpleStringProperty(nom_e);
		this.prènom_e =  new SimpleStringProperty(prènom_e);
		this.contact_e = new SimpleStringProperty(contact_e);
	}
	public int getIdencadrant() {
		return idencadrant.get();
	}
	public void setIdencadrant(int idencadrant) {
		this.idencadrant = new SimpleIntegerProperty(idencadrant);
	}
	public String getNom_e() {
		return nom_e.get();
	}
	public void setNom_e(String nom_e) {
		this.nom_e = new SimpleStringProperty(nom_e);
	}
	public String getPrènom_e() {
		return prènom_e.get();
	}
	public void setPrènom_e(String prènom_e) {
		this.prènom_e = new SimpleStringProperty(prènom_e);
	}
	public String getContact_e() {
		return contact_e.get();
	}
	public void setContact_e(String contact_e) {
		this.contact_e = new SimpleStringProperty(contact_e);
	}
	

}

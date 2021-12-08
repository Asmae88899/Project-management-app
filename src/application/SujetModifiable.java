package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SujetModifiable {
	private SimpleIntegerProperty idsujet;
	private SimpleStringProperty nom_s;
	private SimpleStringProperty document_s;
	private SimpleStringProperty description;

	public SujetModifiable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SujetModifiable(int idsujet, String nom_s, String document_s, String description) {
		super();
		this.idsujet=new SimpleIntegerProperty(idsujet);
		this.nom_s = new SimpleStringProperty(nom_s);
		this.document_s = new SimpleStringProperty(document_s);
		this.description = new SimpleStringProperty(description);
	}
	public int getIdsujet() {
		return idsujet.get();
	}
	public void setIdsujet(int idsujet) {
		this.idsujet = new SimpleIntegerProperty(idsujet);
	}
	public String getNom_s() {
		return nom_s.get();
	}
	public void setNom_s(String nom_s) {
		this.nom_s = new SimpleStringProperty(nom_s);
	}
	public String getDocument_s() {
		return document_s.get();
	}
	public void setDocument_s(String document_s) {
		this.document_s = new SimpleStringProperty(document_s);
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description = new SimpleStringProperty(description);
	}
	
	
	
	

}

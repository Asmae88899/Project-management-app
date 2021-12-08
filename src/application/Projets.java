package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Projets {
	private SimpleIntegerProperty idprojet;
	private SimpleStringProperty nom;
	public Projets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Projets(String nom) {
		super();
		this.nom = new SimpleStringProperty(nom);
	}
	public int getIdprojet() {
		return idprojet.get();
	}
	public void setIdprojet(int idprojet) {
		this.idprojet = new SimpleIntegerProperty(idprojet);
	}
	public String getNom() {
		return nom.get();
	}
	public void setNom(String nom) {
		this.nom = new SimpleStringProperty(nom);
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}



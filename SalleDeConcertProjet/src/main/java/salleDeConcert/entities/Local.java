package model;

import java.util.List;

public class Local {
	private int id;
	private String nom;
	private List<Evenement> evenements;
	

	public Local(int id, String nom, List<Evenement> evenements) {
		this.id = id;
		this.nom = nom;
		this.evenements = evenements;
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

	
	

	public List<Evenement> getEvenements() {
		return evenements;
	}




	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}


	@Override
	public String toString() {
		return "Local [id=" + id + ", nom=" + nom + ", evenements=" + evenements + "]";
	}




	
	
	
	
}

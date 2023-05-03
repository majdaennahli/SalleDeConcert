package model;

public class Prestation {
	private int id;
	private String nom;
	private Evenement evenement;
	private Artiste artiste;
	

	public Prestation(int id, String nom, Evenement evenement, Artiste artiste) {
		this.id = id;
		this.nom = nom;
		this.evenement = evenement;
		this.artiste = artiste;
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

	

	public Evenement getEvenement() {
		return evenement;
	}


	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}


	public Artiste getArtiste() {
		return artiste;
	}


	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}


	@Override
	public String toString() {
		return "Prestation [id=" + id + ", nom=" + nom + ", evenement=" + evenement + "]";
	}


	
	
	
	
}

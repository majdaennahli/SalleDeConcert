package model;

import java.util.List;

public class Artiste {
	private int id;
	private String nomArtiste;
	private String nationalite;
	private List<Prestation> prestations;
	

	public Artiste(int id, String nomArtiste, String nationalite, List<Prestation> prestations) {
		this.id = id;
		this.nomArtiste = nomArtiste;
		this.nationalite = nationalite;
		this.prestations = prestations;
	}
	
	public Artiste(String nomArtiste, String nationalite, List<Prestation> prestations) {
		this.nomArtiste = nomArtiste;
		this.nationalite = nationalite;
		this.prestations = prestations;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomArtiste() {
		return nomArtiste;
	}


	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}


	public List<Prestation> getPrestations() {
		return prestations;
	}


	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}

	@Override
	public String toString() {
		return "Artiste [id=" + id + ", nomArtiste=" + nomArtiste + ", nationalite=" + nationalite + ", prestations="
				+ prestations + "]";
	}


	
	



	
	
	
	
}

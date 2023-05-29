package projetFinal.salleDeConcert.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="artiste")
public class Artiste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="artiste_id")
	private int id;
	@Column(name="artiste_nom")
	private String nomArtiste;
	@Column(name="artiste_nationalite")
	private String nationalite;
	
	@ManyToMany(mappedBy = "artistes")
	private Set<Evenement> evenements;


	public Artiste() {
	
	}

	public Artiste(String nomArtiste, String nationalite) {
	
		this.nomArtiste = nomArtiste;
		this.nationalite = nationalite;
	
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

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artiste other = (Artiste) obj;
		return id == other.id;
	}
	

	

	}


	
	



	
	
	
	


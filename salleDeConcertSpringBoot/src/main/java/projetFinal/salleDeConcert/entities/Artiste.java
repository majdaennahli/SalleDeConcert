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

import com.fasterxml.jackson.annotation.JsonView;

import projetFinal.salleDeConcert.entities.jsonviews.JsonViews;

@Entity
@Table(name="artiste")
public class Artiste {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="artiste_id")
	@JsonView(JsonViews.Base.class)
	private Long id;
	@Column(name="artiste_nom")
	@JsonView(JsonViews.Base.class)
	private String nomArtiste;
	@Column(name="artiste_nationalite")
	@JsonView(JsonViews.Base.class)
	private String nationalite;
	@JsonView(JsonViews.ArtisteWithEvenements.class)
	@ManyToMany(mappedBy = "artistes")
	private Set<Evenement> evenements;
	@Column(name="artiste_image")
	@JsonView(JsonViews.Base.class)
	private String imageURL;


	public Artiste() {
	
	}

	public Artiste(String nomArtiste, String nationalite) {
	
		this.nomArtiste = nomArtiste;
		this.nationalite = nationalite;
	
	}

	
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	
	
	public Set<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
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


	
	



	
	
	
	


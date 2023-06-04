package projetFinal.salleDeConcert.entities;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinal.salleDeConcert.entities.jsonviews.JsonViews;


@Entity
@Table(name="localisation")
public class Local {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="local_id")
	@JsonView(JsonViews.Base.class)
	private Long id;
	@Column(name="local_name")
	@JsonView(JsonViews.Base.class)
	private String nom;
	@OneToMany(mappedBy = "local")
	@JsonView(JsonViews.LocalWithEvenements.class)
	private Set<Evenement> evenements;
	@Column(name="local_places_pmr")
	@JsonView(JsonViews.Base.class)
	private int placesPMR;
	@Column(name="local_places_assises")
	@JsonView(JsonViews.Base.class)
	private int placesAssises;
	@Column(name="local_places_fosse")
	@JsonView(JsonViews.Base.class)
	private int placesFosse;
	@Column(name="local_image")
	@JsonView(JsonViews.Base.class)
	private String imageURL;
	public Local() {
	
	}
	public Local(String nom) {
		this.nom = nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Evenement> getEvenements() {
		return evenements;
	}
	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}
	
	public int getPlacesPMR() {
		return placesPMR;
	}
	public void setPlacesPMR(int placesPMR) {
		this.placesPMR = placesPMR;
	}
	public int getPlacesAssises() {
		return placesAssises;
	}
	public void setPlacesAssises(int placesAssises) {
		this.placesAssises = placesAssises;
	}
	public int getPlacesFosse() {
		return placesFosse;
	}
	public void setPlacesFosse(int placesFosse) {
		this.placesFosse = placesFosse;
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
		Local other = (Local) obj;
		return id == other.id;
	}
	

	


	
	
	
	
}

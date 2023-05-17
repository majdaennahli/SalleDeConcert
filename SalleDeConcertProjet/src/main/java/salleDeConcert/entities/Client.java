package salleDeConcert.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import salleDeConcert.entities.jsonviews.JsonViews;



@Entity
@Table(name="client")
@AttributeOverride(name="id",column = @Column(name="client_id"))
@AttributeOverride( name="login", column = @Column(name="client_login"))
@AttributeOverride( name="password", column = @Column(name="client_password"))
@AttributeOverride( name="email", column = @Column(name="client_email"))

public class Client extends Compte{
	@NotBlank
	@Column(name="client_nom")
	@JsonView(JsonViews.Base.class)
	private String nom;
	@NotBlank
	@Column(name="client_prenom")
	@JsonView(JsonViews.Base.class)
	private String prenom;
	@NotBlank
	@Column(name="client_tel")
	@JsonView(JsonViews.Base.class)
	private String telephone;
	@NotNull
	@Column(name="client_naissance")
	@JsonView(JsonViews.Base.class)
	private LocalDate naissance;
	
	@OneToMany(mappedBy = "client")
	@JsonView(JsonViews.ClientWithReservations.class)
	private Set <Reservation> reservations;
	
	public Client() {

	}


	public Client(String nom, String prenom, String telephone, LocalDate naissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.naissance = naissance;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public LocalDate getNaissance() {
		return naissance;
	}


	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}


	public Set<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	
	
}

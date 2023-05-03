package salleDeConcert.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="client")
@AttributeOverride(name="id",column = @Column(name="client_id"))
@AttributeOverride( name="login", column = @Column(name="client_login"))
@AttributeOverride( name="password", column = @Column(name="client_password"))
@AttributeOverride( name="email", column = @Column(name="client_email"))

public class Client extends Compte{
	
	@Column(name="client_nom")
	private String nom;
	@Column(name="client_prenom")
	private String prenom;
	@Column(name="client_tel")
	private String telephone;
	@Column(name="client_naissance")
	private LocalDate naissance;
	
@OneToMany(mappedBy = "client")
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

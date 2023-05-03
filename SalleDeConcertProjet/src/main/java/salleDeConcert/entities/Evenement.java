package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public abstract class Evenement {
	protected int id;
	protected String nom;
	protected double prix;
	protected LocalDate dateDebut;
	protected LocalTime heureDebut;
	protected LocalDate dateFin;
	protected LocalTime heureFin;
	protected Local local;
	protected List<Organisateur> organisateurs;
	protected List<Prestation> prestations;
	protected List<Reservation> reservations;
	

	public Evenement(int id, String nom, double prix, LocalDate dateDebut, LocalTime heureDebut, LocalDate dateFin,
			LocalTime heureFin, Local local, List<Organisateur> organisateurs, List<Prestation> prestations,
			List<Reservation> reservations) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
		this.dateFin = dateFin;
		this.heureFin = heureFin;
		this.local = local;
		this.organisateurs = organisateurs;
		this.prestations = prestations;
		this.reservations = reservations;
	}
	

	public Evenement(String nom, double prix, LocalDate dateDebut, LocalTime heureDebut, LocalDate dateFin,
			LocalTime heureFin, Local local, List<Organisateur> organisateurs, List<Prestation> prestations,
			List<Reservation> reservations) {
		this.nom = nom;
		this.prix = prix;
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
		this.dateFin = dateFin;
		this.heureFin = heureFin;
		this.local = local;
		this.organisateurs = organisateurs;
		this.prestations = prestations;
		this.reservations = reservations;
	}



	public Local getLocal() {
		return local;
	}


	public void setLocal(Local local) {
		this.local = local;
	}


	public List<Organisateur> getOrganisateurs() {
		return organisateurs;
	}


	public void setOrganisateurs(List<Organisateur> organisateurs) {
		this.organisateurs = organisateurs;
	}


	public List<Prestation> getPrestations() {
		return prestations;
	}


	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
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

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalTime getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(LocalTime heureDebut) {
		this.heureDebut = heureDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public LocalTime getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(LocalTime heureFin) {
		this.heureFin = heureFin;
	}

	
	public String toString() {
		return "Evenement [id=" + id + ", nom=" + nom + ", prix=" + prix + ", dateDebut=" + dateDebut + ", heureDebut="
				+ heureDebut + ", dateFin=" + dateFin + ", heureFin=" + heureFin + "]";
	}
	
	
}

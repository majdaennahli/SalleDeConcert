package model;

import java.time.LocalDate;
import java.util.List;

public class Reservation {
	private int id;
	private double prix;
	private LocalDate dateReserv;
	private Client client;
	private List<Participation> participations;
	private Evenement evenement;
	
	
	public Reservation(int id, int prix, LocalDate dateReserv, Client client, List<Participation> participations,
			Evenement evenement) {
		this.id = id;
		this.prix = prix;
		this.dateReserv = dateReserv;
		this.client = client;
		this.participations = participations;
		this.evenement = evenement;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public LocalDate getDateReserv() {
		return dateReserv;
	}


	public void setDateReserv(LocalDate dateReserv) {
		this.dateReserv = dateReserv;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<Participation> getParticipations() {
		return participations;
	}


	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}


	public Evenement getEvenement() {
		return evenement;
	}


	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}


	@Override
	public String toString() {
		return "Reservation [id=" + id + ", prix=" + prix + ", dateReserv=" + dateReserv + ", client=" + client
				+ ", evenement=" + evenement + "]";
	}
	
	
}

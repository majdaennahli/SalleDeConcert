package salleDeConcert.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reservation_id")
	private int id;
	@Column(name="reservation_price")
	private double prix;
	@Column(name="reservation_date")
	private LocalDate dateReserv;
@ManyToOne
@JoinColumn(name="reservation_client_id",foreignKey = @ForeignKey(name="reservation_client_id_fk"))
private Client client;
	@ManyToOne
	@JoinColumn(name="reservation_event_id",foreignKey = @ForeignKey(name="reservation_event_id_fk"))
	private Evenement evenement;
	@ManyToMany(mappedBy = "reservations")
	private Set <Participant> participants;
	public Reservation() {
	
	}
	public Reservation(double prix, LocalDate dateReserv) {
		super();
		this.prix = prix;
		this.dateReserv = dateReserv;

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
	public void setPrix(double prix) {
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
	public void SetClient(Client client) {
		this.client = client;
	}
	
	public Evenement getEvenement() {
		return evenement;
	}
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}
	public Set<Participant> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
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
		Reservation other = (Reservation) obj;
		return id == other.id;
	}
	
	
	
	

	
}

package projetFinal.salleDeConcert.entities;

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

import com.fasterxml.jackson.annotation.JsonView;

import projetFinal.salleDeConcert.entities.jsonviews.JsonViews;


@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reservation_id")
	@JsonView(JsonViews.Base.class)
	private Long id;
	@Column(name="reservation_price")
	@JsonView(JsonViews.Base.class)
	private double prix;
	@Column(name="reservation_date")
	@JsonView(JsonViews.Base.class)
	private LocalDate dateReserv;
	@ManyToOne
	@JoinColumn(name="reservation_client_id",foreignKey = @ForeignKey(name="reservation_client_id_fk"))
	@JsonView(JsonViews.ReservationWithClients.class)
	private Client client;
	@ManyToOne
	@JoinColumn(name="reservation_event_id",foreignKey = @ForeignKey(name="reservation_event_id_fk"))
	@JsonView(JsonViews.ReservationWithEvenements.class)
	private Evenement evenement;
	@ManyToMany(mappedBy = "reservations")
	@JsonView(JsonViews.ReservationWithParticipants.class)
	private Set <Participant> participants;
	
	public Reservation() {
	
	}
	
	public Reservation(double prix, LocalDate dateReserv) {
		super();
		this.prix = prix;
		this.dateReserv = dateReserv;

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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

package salleDeConcert.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="evenement")
public abstract class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private int id;
	@Column(name="event_name")
	private String nom;
	@Column(name="event_price")

	private double prix;
	@Column(name="event_date_begining")
	private LocalDate dateDebut;
	@Column(name="event_time_begining")
	private LocalTime heureDebut;
	@Column(name="event_date_finish")
	private LocalDate dateFin;
	@Column(name="event_time_finish")
	private LocalTime heureFin;
	@ManyToOne
	@JoinColumn(name="event_local_id",foreignKey = @ForeignKey(name="event_local_id_fk"))
	private Local local;
	@ManyToMany
	@JoinTable(
            name="organisation",
            joinColumns = @JoinColumn(name="organisation_staff_id",foreignKey = @ForeignKey(name="organisation_staff_id_fk")),
            inverseJoinColumns = @JoinColumn(name="organisation_event_id",foreignKey = @ForeignKey(name="organisation_event_id_fk")))
    
	private Set<Staff> staffs;
	
	@OneToMany(mappedBy = "evenement")
	private Set<Reservation> reservations;
	
	@ManyToMany
	@JoinTable(
            name="prestation",
            joinColumns = @JoinColumn(name="prestation_artiste_id",foreignKey = @ForeignKey(name="prestation_artiste_id_fk")),
            inverseJoinColumns = @JoinColumn(name="prestation_event_id",foreignKey = @ForeignKey(name="prestation_event_id_fk")))
	
	private Set<Artiste> artistes;
	
	@Enumerated(EnumType.STRING)
	@Column(name="event_type")
	private TypeEvenement typeEvenement;
	public Evenement() {
	
	}
	public Evenement(String nom, double prix, LocalDate dateDebut, LocalTime heureDebut, LocalDate dateFin,
			LocalTime heureFin, Local local,TypeEvenement typeEvenement) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
		this.dateFin = dateFin;
		this.heureFin = heureFin;
		this.local = local;
		this.typeEvenement = typeEvenement;
	
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
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public Set<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(Set<Staff> staffs) {
		this.staffs = staffs;
	}

	
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public TypeEvenement getTypeEvenement() {
		return typeEvenement;
	}
	public void setTypeEvenement(TypeEvenement typeEvenement) {
		this.typeEvenement = typeEvenement;
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
		Evenement other = (Evenement) obj;
		return id == other.id;
	}
	

	
	
	
}

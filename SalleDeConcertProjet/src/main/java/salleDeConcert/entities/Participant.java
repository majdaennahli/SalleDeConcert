package salleDeConcert.entities;

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
import javax.persistence.Table;

@Entity
@Table(name="participant")
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="participant_id")
	private int id;
	@Column(name="participant_name")
	private String nom;
	@Column(name="participant_age")
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Reduc reduc;
	@Enumerated(EnumType.STRING)
	private TypePlace typePlace;
	
	@ManyToMany
	@JoinTable(
            name="participation",
            joinColumns = @JoinColumn(name="participation_participant_id",foreignKey = @ForeignKey(name="participation_participant_id_fk")),
            inverseJoinColumns = @JoinColumn(name="participation_reservation_id",foreignKey = @ForeignKey(name="participation_reservation_id_fk")))
	private Set<Reservation> reservations;
	public Participant() {
	
	}
	public Participant(String nom, int age, Reduc reduc, TypePlace typePlace) {
		super();
		this.nom = nom;
		this.age = age;
		this.reduc = reduc;
		this.typePlace = typePlace;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Reduc getReduc() {
		return reduc;
	}
	public void setReduc(Reduc reduc) {
		this.reduc = reduc;
	}
	public TypePlace getTypePlace() {
		return typePlace;
	}
	public void setTypePlace(TypePlace typePlace) {
		this.typePlace = typePlace;
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
		Participant other = (Participant) obj;
		return id == other.id;
	} 
	
}


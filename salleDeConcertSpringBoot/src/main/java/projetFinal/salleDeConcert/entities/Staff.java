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
@Table(name="staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="staff_id")
	@JsonView(JsonViews.Base.class)
	private Long id;
	@Column(name="staff_name")
	@JsonView(JsonViews.Base.class)
	private String nom;
	@ManyToMany(mappedBy = "staffs")
	@JsonView(JsonViews.StaffWithEvenements.class)
	private Set<Evenement> evenements;
	
	
	public Staff() {

	}
	public Staff(String nom) {
	
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
		Staff other = (Staff) obj;
		return id == other.id;
	}
	
	
	
}

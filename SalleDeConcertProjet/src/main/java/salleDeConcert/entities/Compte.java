package salleDeConcert.entities;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

import salleDeConcert.entities.jsonviews.JsonViews;

@MappedSuperclass
public abstract class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Base.class)
	protected Long id;
	@NotBlank
	@JsonView(JsonViews.Base.class)
	protected String login;
	@NotBlank
	@JsonView(JsonViews.Base.class)
	protected String password;
	

	
	public Compte() {

	}


	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
		Compte other = (Compte) obj;
		return id == other.id;
	}
	
	
}

package model;

import java.time.LocalDate;

public class Client extends Compte{
	
	protected String nom;
	protected String prenom;
	protected String telephone;
	protected LocalDate naissance;
	
	
	public Client(int id, String login, String password, String nom, String prenom, String telephone, LocalDate naissance) {
		super(id, login, password);
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.naissance = naissance;
	}
	
	public Client(String login, String password, String nom, String prenom, String telephone, LocalDate naissance) {
		super(login, password);
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


	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", naissance=" + naissance
				+ "]";
	}
	
	
}

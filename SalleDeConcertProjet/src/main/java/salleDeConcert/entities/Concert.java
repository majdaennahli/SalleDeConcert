package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Concert extends Evenement{

	public Concert(int id, String nom, double prix, LocalDate dateDebut, LocalTime heureDebut, LocalDate dateFin,
			LocalTime heureFin, Local local, List<Organisateur> organisateurs, List<Prestation> prestations,
			List<Reservation> reservations) {
		super(id, nom, prix, dateDebut, heureDebut, dateFin, heureFin, local, organisateurs, prestations, reservations);
		// TODO Auto-generated constructor stub
	}

	public Concert(String nom, double prix, LocalDate dateDebut, LocalTime heureDebut, LocalDate dateFin,
			LocalTime heureFin, Local local, List<Organisateur> organisateurs, List<Prestation> prestations,
			List<Reservation> reservations) {
		super(nom, prix, dateDebut, heureDebut, dateFin, heureFin, local, organisateurs, prestations, reservations);
		// TODO Auto-generated constructor stub
	}

	
	
	
}

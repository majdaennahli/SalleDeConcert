package salleDeConcert.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salleDeConcert.entities.Evenement;
import salleDeConcert.entities.Reservation;
import salleDeConcert.exceptions.EvenementException;
import salleDeConcert.exceptions.ReservationException;
import salleDeConcert.repositories.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepo;
	
	private void checkReservation(Reservation reservation) {
		if (reservation == null) {
			throw new ReservationException("reservation null");
		}
		if (reservation.getPrix() <0 ) {
			throw new ReservationException("Prix obligatoire");
		}
		if (reservation.getEvenement() ==null ) {
			throw new ReservationException("Evenement obligatoire");
		}
		if (reservation.getClient() ==null ) {
			throw new ReservationException("Client obligatoire");
		}
		if (reservation.getDateReserv() ==null ) {
			throw new ReservationException("Date de reservation obligatoire");
		}
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new ReservationException("id null");
		}
	}

	public Reservation create(Reservation reservation) {
		checkReservation(reservation);
		return reservationRepo.save(reservation);
	}
	
	public void delete(Reservation reservation) {
		delete(reservation.getId());
	}
	public void delete(Long id) {
		Reservation reservationEnBase = getById(id);
		reservationRepo.delete(reservationEnBase);

	}

	public Reservation getById(Long id) {
		checkId(id);
		return reservationRepo.findById(id).orElseThrow(() -> {
			throw new EvenementException("id inconnu");
		});
	}
}

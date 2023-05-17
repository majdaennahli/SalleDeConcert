package salleDeConcert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	
	public List<Reservation> getAll(){
		return reservationRepo.findAll();
	}

	public Reservation create(Reservation reservation) {
		checkReservation(reservation);
		return reservationRepo.save(reservation);
	}
	
	public Reservation update(Reservation reservation) {
		checkReservation(reservation);
		Reservation reservationEnBase = getById(reservation.getId());
		reservationEnBase.setPrix(reservation.getPrix());
		reservationEnBase.setDateReserv(reservation.getDateReserv());
		reservationEnBase.SetClient(reservation.getClient());
		reservationEnBase.setEvenement(reservation.getEvenement());
		reservationEnBase.setParticipants(reservation.getParticipants());
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
	
	public List<Reservation> getByEvenementId(Long idEvenement){
		checkId(idEvenement);
		return reservationRepo.findByEvenementId(idEvenement);
	}
	
	public List<Reservation> getByClientId(Long idClient){
		checkId(idClient);
		return reservationRepo.findByClientId(idClient);
	}
	
	public Reservation getByIdWithParticipants(Long id){
		checkId(id);
		return reservationRepo.findByIdFetchParticipants(id).orElseThrow(() -> {
			throw new ReservationException("id inconnu");
		});
	}
	
	public Page<Reservation> getPage(int page) {
		Pageable pageable = PageRequest.of(page, 10); //10 element par page
		return getPage(pageable);
	}

	public Page<Reservation> getPage(Pageable pageable) {
		return reservationRepo.findAll(pageable);
	}
}

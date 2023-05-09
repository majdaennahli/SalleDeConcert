package salleDeConcert.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salleDeConcert.entities.Participant;
import salleDeConcert.entities.Reservation;
import salleDeConcert.exceptions.EvenementException;
import salleDeConcert.exceptions.ParticipantException;
import salleDeConcert.repositories.ParticipantRepository;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepository participantRepo;
	
	
	private void checkParticipant(Participant participant) {
		if (participant == null) {
			throw new ParticipantException("participant null");
		}
		if (participant.getNom() == null || participant.getNom().isEmpty()) {
			throw new ParticipantException("nom obligatoire");
		}
		if (participant.getAge() <0) {
			throw new ParticipantException("age obligatoire");
		}
		if (participant.getTypePlace() ==null) {
			throw new ParticipantException("type de place obligatoire");
		}
		if (participant.getReservations() ==null) {
			throw new ParticipantException("reservation obligatoire");
		}
	}
	
	private void checkId(Long id) {
		if (id == null) {
			throw new ParticipantException("id null");
		}
	}
	
	public Participant create(Participant participant) {
		checkParticipant(participant);
		return participantRepo.save(participant);
	}

	
	public Participant getById(Long id) {
		checkId(id);
		return participantRepo.findById(id).orElseThrow(() -> {
			throw new ParticipantException("id inconnu");
		});
	}
	
	public void delete(Participant participant) {
		delete(participant.getId());
	}
	public void delete(Long id) {
		Participant participantEnBase = getById(id);
		participantRepo.delete(participantEnBase);

	}

	
}

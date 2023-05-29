package projetFinal.salleDeConcert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.salleDeConcert.entities.Participant;
import projetFinal.salleDeConcert.exceptions.EvenementException;
import projetFinal.salleDeConcert.exceptions.ParticipantException;
import projetFinal.salleDeConcert.repositories.ParticipantRepository;

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
	
	public List<Participant> getAll() {
		return participantRepo.findAll();
	}
	
	private void checkId(Long id) {
		if (id == null) {
			throw new ParticipantException("id null");
		}
	}
	
	private void checkIdEvenement(Long id) {
		if (id == null) {
			throw new EvenementException("id Evenement null");
		}
	}
	
	public Participant getById(Long id) {
		checkId(id);
		return participantRepo.findById(id).orElseThrow(() -> {
			throw new ParticipantException("id inconnu");
		});
	}
	
	public Participant create(Participant participant) {
		checkParticipant(participant);
		return participantRepo.save(participant);
	}
	
	public Participant update(Participant participant) {
		Participant participantEnBase = getById(participant.getId());
		checkParticipant(participant);
		participantEnBase.setNom(participant.getNom());
		participantEnBase.setAge(participant.getAge());
		participantEnBase.setReduc(participant.getReduc());
		participantEnBase.setTypePlace(participant.getTypePlace());
		return participantRepo.save(participantEnBase);
	}
	
	public void delete(Participant participant) {
		delete(participant.getId());
	}
	
	public void delete(Long id) {
		Participant participantEnBase = getById(id);
		participantRepo.delete(participantEnBase);
	}
	
	public List<Participant> findByIdEvenement(Long idEvenement){
		checkIdEvenement(idEvenement);
		return participantRepo.findByIdEvenement(idEvenement);
	}

//	public Long countByEvenement(Long idEvenement) {
//		checkIdEvenement(idEvenement);
//		return participantRepo.countByEvenements(idEvenement);
//	}
}







package projetFinal.salleDeConcert.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projetFinal.salleDeConcert.entities.Evenement;
import projetFinal.salleDeConcert.entities.Local;
import projetFinal.salleDeConcert.entities.TypeEvenement;
import projetFinal.salleDeConcert.exceptions.EvenementException;
import projetFinal.salleDeConcert.repositories.EvenementRepository;
import projetFinal.salleDeConcert.repositories.ReservationRepository;

@Service
public class EvenementService {

	@Autowired
	private EvenementRepository evenementRepo;
	@Autowired
	private ReservationRepository reservationRepo;

	private void checkEvenement(Evenement evenement) {
		if (evenement == null) {
			throw new EvenementException("evenement null");
		}
		if (evenement.getNom() == null || evenement.getNom().isEmpty()) {
			throw new EvenementException("nom obligatoire");
		}
		if (evenement.getPrix() < 0.01) {
			throw new EvenementException("prix obligatoire");
		}
		if (evenement.getDateDebut() == null || evenement.getDateFin() == null) {
			throw new EvenementException("date non renseignée");
		}
		if (evenement.getHeureDebut() == null || evenement.getHeureFin() == null) {
			throw new EvenementException("heure non renseignée");
		}
		if (evenement.getLocal() == null) {
			throw new EvenementException("local obligatoire");
		}
		if (evenement.getTypeEvenement() == null) {
			throw new EvenementException("type d'évenement à renseigner");
		}
		if (evenement.getStaffs() == null ||evenement.getStaffs().isEmpty() ) {
			throw new EvenementException("staffs à renseigner");
		}
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new EvenementException("id null");
		}
	}

	public Evenement create(Evenement evenement) {
		checkEvenement(evenement);
		return evenementRepo.save(evenement);
	}

	public Evenement update(Evenement evenement) {
		Evenement evenementEnBase = getById(evenement.getId());
		checkEvenement(evenement);
		evenementEnBase.setNom(evenement.getNom());
		evenementEnBase.setDateDebut(evenement.getDateDebut());
		evenementEnBase.setDateFin(evenement.getDateFin());
		evenementEnBase.setHeureDebut(evenement.getHeureDebut());
		evenementEnBase.setHeureFin(evenement.getHeureFin());
		evenementEnBase.setLocal(evenement.getLocal());
		evenementEnBase.setPrix(evenement.getPrix());
		evenementEnBase.setStaffs(evenement.getStaffs());
		evenementEnBase.setTypeEvenement(evenement.getTypeEvenement());
		evenementEnBase.setArtistes(evenement.getArtistes());
		evenementEnBase.setImageURL(evenement.getImageURL());
		return evenementRepo.save(evenementEnBase);
	}

	public Evenement getById(Long id) {
		checkId(id);
		return evenementRepo.findById(id).orElseThrow(() -> {
			throw new EvenementException("id inconnu");
		});
	}
	public void delete(Evenement evenement) {
		delete(evenement.getId());
	}
	public void delete(Long id) {
		Evenement evenementEnBase = getById(id);
		reservationRepo.deleteById(evenementEnBase.getId());
	}
	
	public List<Evenement> getAll() {
		return evenementRepo.findAll();
	}

	public List<Evenement> getByNom(String nom) {
		return evenementRepo.findByNomContaining(nom);
	}
	
	public List<Evenement> getByDate(LocalDate dateDebut) {
		return evenementRepo.findByDateDebut(dateDebut);
	}
	
	public Optional<Evenement> getByNomArtiste(String nomArtiste) {
		return evenementRepo.findByNomArtiste(nomArtiste);
	}
	
	public List<Evenement> getByLocal(Local local) {
		return evenementRepo.findByLocal(local);
	}
	public List<Evenement> getByTypeEvenement(TypeEvenement typeEvenement) {
		return evenementRepo.findByTypeEvenement(typeEvenement);
	}
	
	public Optional<Evenement> getByTypeEvenementAndDate(TypeEvenement typeEvenement, LocalDate dateDebut) {
		return evenementRepo.findByTypeEvenementAndDate(typeEvenement, dateDebut);
	}
	
	public Optional<Evenement> getByTypeEvenementAndDateToCome(TypeEvenement typeEvenement) {
		return evenementRepo.findByTypeEvenementToCome(typeEvenement);
	}
	
	public Evenement getByIdWithArtistes(Long id){
		checkId(id);
		return evenementRepo.findByIdFetchArtistes(id).orElseThrow(() -> {
			throw new EvenementException("id inconnu");
		});
	}
	
	public Evenement getByIdWithStaffs(Long id){
		checkId(id);
		return evenementRepo.findByIdFetchStaffs(id).orElseThrow(() -> {
			throw new EvenementException("id inconnu");
		});
	}
	
	public int findDureeJours(Long id) {
		checkId(id);
		return evenementRepo.findDureeJours(id).orElseThrow(() -> {
			throw new EvenementException("id inconnu");
		});
	}
	
	public String findDureeHeures(Long id) {
		checkId(id);
		return evenementRepo.findDureeHeures(id).orElseThrow(() -> {
			throw new EvenementException("id inconnu");
		});
	}

	public Page<Evenement> getPage(int page) {
		Pageable pageable = PageRequest.of(page, 10); //10 element par page
		return getPage(pageable);
	}

	public Page<Evenement> getPage(Pageable pageable) {
		return evenementRepo.findAll(pageable);
	}
}

package projetFinal.salleDeConcert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projetFinal.salleDeConcert.entities.Local;
import projetFinal.salleDeConcert.exceptions.LocalException;
import projetFinal.salleDeConcert.repositories.LocalRepository;

@Service
public class LocalService {
	@Autowired
	private LocalRepository localRepo;
	
	private void checkLocal(Local local) {
		if (local == null) {
			throw new LocalException("local null");
		}
		if (local.getNom() == null || local.getNom().isEmpty()) {
			throw new LocalException("nom obligatoire");
		}
	}
	
	private void checkId(Long id) {
		if (id == null) {
			throw new LocalException("id null");
		}
	}
	
	public Local create(Local local) {
		checkLocal(local);
		return localRepo.save(local);
	}

	public Local update(Local local) {
		Local localEnBase = getById(local.getId());
		checkLocal(local);
		localEnBase.setNom(local.getNom());
		localEnBase.setEvenements(local.getEvenements());
		localEnBase.setPlacesAssises(local.getPlacesAssises());
		localEnBase.setPlacesFosse(local.getPlacesFosse());
		localEnBase.setPlacesPMR(local.getPlacesPMR());
		return localRepo.save(localEnBase);
	}

	public Local getById(Long id) {
		checkId(id);
		return localRepo.findById(id).orElseThrow(() -> {
			throw new LocalException("id inconnu");
		});
	}
	
	public Local getByIdWithEvenements(Long id) {
		checkId(id);
		return localRepo.findByIdFetchEvenements(id).orElseThrow(() -> {
			throw new LocalException("id inconnu");
		});
	}
	
	
	public List<Local> getAll() {
		return localRepo.findAll();
	}

	

	public Page<Local> getPage() {
		return getPage(0, 20);
	}

	public Page<Local> getPage(int size) {
		return getPage(0, size);
	}

	public Page<Local> getPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return getPage(pageable);
	}

	public Page<Local> getPage(Pageable pageable) {
		return localRepo.findAll(pageable);
	}
	
//	public void delete(Local local) {
//		delete(local.getId());
//	}
//
//	public void delete(Long id) {
//		Local local = getByIdWithReservations(id);
//		local.getReservations().forEach(reservationSrv::delete);
//		local.setReservations(null);
//		localRepo.delete(local);
//
//	}
	
}

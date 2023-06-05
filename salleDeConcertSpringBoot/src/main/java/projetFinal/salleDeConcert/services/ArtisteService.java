package projetFinal.salleDeConcert.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projetFinal.salleDeConcert.entities.Artiste;
import projetFinal.salleDeConcert.exceptions.ArtisteException;
import projetFinal.salleDeConcert.repositories.ArtisteRepository;

@Service
public class ArtisteService {

	@Autowired
	private ArtisteRepository artisteRepo;
	
	
	private void checkArtiste(Artiste artiste) {
		if (artiste == null) {
			throw new ArtisteException("artiste null");
		}
		if (artiste.getNomArtiste() == null || artiste.getNomArtiste().isEmpty()) {
			throw new ArtisteException("nom d'artiste obligatoire");
		}
	}
	
	private void checkId(Long id) {
		if (id == null) {
			throw new ArtisteException("id null");
		}
	}
	
	public Artiste create(Artiste artiste) {
		checkArtiste(artiste);
		return artisteRepo.save(artiste);
	}

	public Artiste update(Artiste artiste) {
		Artiste artisteEnBase = getById(artiste.getId());
		checkArtiste(artiste);
		artisteEnBase.setNomArtiste(artiste.getNomArtiste());
		artisteEnBase.setNationalite(artiste.getNationalite());
		artisteEnBase.setEvenements(artiste.getEvenements());
		artisteEnBase.setImageURL(artiste.getImageURL());
		return artisteRepo.save(artisteEnBase);
	}

	public Artiste getById(Long id) {
		checkId(id);
		return artisteRepo.findById(id).orElseThrow(() -> {
			throw new ArtisteException("id inconnu");
		});
	}
	public Artiste getByIdWithEvenements(Long id) {
		checkId(id);
		return artisteRepo.findByIdFetchEvenements(id).orElseThrow(() -> {
			throw new ArtisteException("id inconnu");
		});
	}
	
	public List<Artiste> getAll() {
		return artisteRepo.findAll();
	}

	
	public List<Artiste> getByNomArtisteContaining(String nomArtiste){
		return artisteRepo.findByNomArtisteContaining(nomArtiste);
	}

	public Page<Artiste> getPage() {
		return getPage(0, 20);
	}

	public Page<Artiste> getPage(int size) {
		return getPage(0, size);
	}

	public Page<Artiste> getPage(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return getPage(pageable);
	}

	public Page<Artiste> getPage(Pageable pageable) {
		return artisteRepo.findAll(pageable);
	}
	
	public void delete(Artiste artiste) {
		delete(artiste.getId());
	}

	public void delete(Long id) {
		Artiste artiste= this.getById(id);
		artisteRepo.delete(artiste);

	}
}

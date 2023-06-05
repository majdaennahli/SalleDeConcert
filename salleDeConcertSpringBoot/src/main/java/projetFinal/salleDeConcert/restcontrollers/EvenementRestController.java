package projetFinal.salleDeConcert.restcontrollers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import projetFinal.salleDeConcert.entities.Evenement;
import projetFinal.salleDeConcert.entities.Local;
import projetFinal.salleDeConcert.entities.jsonviews.JsonViews;
import projetFinal.salleDeConcert.services.EvenementService;
import projetFinal.salleDeConcert.services.LocalService;

@RestController
@RequestMapping("/api/evenement")
@CrossOrigin(origins = "*")
public class EvenementRestController {

	@Autowired
	private EvenementService evenementSrv;
	
	@Autowired
	private LocalService localSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Evenement.class)
	public List<Evenement> getAll() {
		return evenementSrv.getAll();
	}	

	@GetMapping("/page/{page}")
	@JsonView(JsonViews.Evenement.class)
	public Page<Evenement> getPage(@PathVariable int page) {
	    return evenementSrv.getPage(page);
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.EvenementWithStaffsAndArtistes.class)
	public Evenement getById(@PathVariable("id") Long id) {
		return evenementSrv.getById(id);
	}
	
	@GetMapping("/nom/{nom}")
	@JsonView(JsonViews.Evenement.class)
	public List<Evenement> getByNom(@PathVariable("nom") String nom) {
		return evenementSrv.getByNom(nom);
	}
	
	@GetMapping("/date/{date}")
	@JsonView(JsonViews.Evenement.class)
	public List<Evenement> getByDate(@PathVariable("date")LocalDate dateDebut) {
		return evenementSrv.getByDate(dateDebut);
	}
	
	@GetMapping("/nom-artiste/{nomArtiste}")
	@JsonView(JsonViews.Evenement.class)
	public Optional<Evenement> getByNomArtiste(@PathVariable("nomArtiste")String nomArtiste) {
		return evenementSrv.getByNomArtiste(nomArtiste);
	}
	@GetMapping("/local/{id}")
	@JsonView(JsonViews.Evenement.class)
	public List<Evenement> getByDate(@PathVariable("id")Long id) {
		Local local = localSrv.getById(id);
		return evenementSrv.getByLocal(local);
	}
	
	@GetMapping("/{id}/artistes")
	@JsonView(JsonViews.EvenementWithArtistes.class)
	public Evenement getByIdWithArtistes(@PathVariable("id") Long id) {
		return evenementSrv.getByIdWithArtistes(id);
	}
	
	@GetMapping("/{id}/staffs")
	@JsonView(JsonViews.EvenementWithStaffs.class)
	public Evenement getByIdWithStaffs(@PathVariable("id") Long id) {
		return evenementSrv.getByIdWithStaffs(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Evenement.class)
	public Evenement create(@Valid @RequestBody Evenement evenement,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return evenementSrv.create(evenement);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Evenement.class)
	public Evenement update(@Valid @RequestBody Evenement evenement,BindingResult br,@PathVariable Long id) {
		evenement.setId(id);
		return evenementSrv.update(evenement);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		evenementSrv.delete(id);
	}
}

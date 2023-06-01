package projetFinal.salleDeConcert.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import projetFinal.salleDeConcert.entities.Artiste;
import projetFinal.salleDeConcert.entities.jsonviews.JsonViews;
import projetFinal.salleDeConcert.services.ArtisteService;

@RestController
@RequestMapping("/api/artiste")
@CrossOrigin(origins = "http://localhost:4200")
public class ArtisteRestController {

	@Autowired
	private ArtisteService artisteSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Artiste.class)
	public List<Artiste> getAll() {
		return artisteSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Artiste.class)
	public Artiste getById(@PathVariable("id") Long id) {
		return artisteSrv.getById(id);
	}
	
	@GetMapping("/{id}/evenements")
	@JsonView(JsonViews.ArtisteWithEvenements.class)
	public Artiste getByIdWithEvenements(@PathVariable("id") Long id) {
		return artisteSrv.getByIdWithEvenements(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Artiste.class)
	public Artiste create(@Valid @RequestBody Artiste artiste,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return artisteSrv.create(artiste);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Artiste.class)
	public Artiste update(@Valid @RequestBody Artiste artiste,BindingResult br,@PathVariable Long id) {
		artiste.setId(id);
		return artisteSrv.update(artiste);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		artisteSrv.delete(id);
	}
}

package projetFinal.salleDeConcert.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import projetFinal.salleDeConcert.entities.Local;
import projetFinal.salleDeConcert.entities.jsonviews.JsonViews;
import projetFinal.salleDeConcert.services.LocalService;

@RestController
@RequestMapping("/api/local")
@CrossOrigin(origins = "*")
public class LocalRestController {
	
	@Autowired
	private LocalService localSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Local.class)
	public List<Local> getAll() {
		return localSrv.getAll();
	}
	@GetMapping("/{id}")
	@JsonView(JsonViews.Local.class)
	public Local getById(@PathVariable("id") Long id) {
		return localSrv.getById(id);
	}
	@GetMapping("/{id}/evenements")
	@JsonView(JsonViews.LocalWithEvenements.class)
	public Local getByIdWithEvenements(@PathVariable("id") Long id) {
		return localSrv.getByIdWithEvenements(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Local.class)
	public Local create(@Valid @RequestBody Local local,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return localSrv.create(local);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Local.class)
	public Local update(@Valid @RequestBody Local local,BindingResult br,@PathVariable Long id) {
		local.setId(id);
		return localSrv.update(local);
	}
}

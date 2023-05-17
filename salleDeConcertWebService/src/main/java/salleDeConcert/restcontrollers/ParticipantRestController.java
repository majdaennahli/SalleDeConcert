package salleDeConcert.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import salleDeConcert.entities.Participant;
import salleDeConcert.entities.jsonviews.JsonViews;
import salleDeConcert.services.ParticipantService;

@RestController
@RequestMapping("/api/participant")
public class ParticipantRestController {
	
	@Autowired
	private ParticipantService participantSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Participant.class)
	public List<Participant> getAll(){
		return participantSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Participant.class)
	public Participant getById(@PathVariable("id") Long id) {
		return participantSrv.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Participant.class)
	public Participant create(@Valid @RequestBody Participant participant,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return participantSrv.create(participant);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Participant.class)
	public Participant update(@Valid @RequestBody Participant participant,BindingResult br,@PathVariable Long id) {
		participant.setId(id);
		return participantSrv.update(participant);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		participantSrv.delete(id);
	}
	
	@GetMapping("/{idEvenement}/participants")
	@JsonView(JsonViews.Participant.class)
	public List<Participant> getByIdEvenement(@PathVariable("idEvenement") Long id) {
		return participantSrv.findByIdEvenement(id);
	}
	
//	@GetMapping("/{idEvenement}/count")
//	public Long countByEvenement (@PathVariable("idEvenement") Long id) {
//		return participantSrv.countByEvenement(id);
//	}
}

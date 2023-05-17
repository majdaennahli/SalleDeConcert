package salleDeConcert.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import salleDeConcert.entities.Reservation;
import salleDeConcert.entities.jsonviews.JsonViews;
import salleDeConcert.services.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Reservation.class)
	public List<Reservation> getAll(){
		return reservationSrv.getAll();
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Reservation.class)
	public Reservation create(@Valid @RequestBody Reservation reservation,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return reservationSrv.create(reservation);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Reservation.class)
	public Reservation update(@Valid @RequestBody Reservation reservation,BindingResult br,@PathVariable Long id) {
		reservation.setId(id);
		return reservationSrv.update(reservation);
	}
	
	// A TESTER
	@GetMapping("/page/{page}")
	@JsonView(JsonViews.Reservation.class)
	public Page<Reservation> getPage(@PathVariable int page) {
	    return reservationSrv.getPage(page);
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Reservation.class)
	public Reservation getById(@PathVariable("id") Long id) {
		return reservationSrv.getById(id);
	}
	
	@GetMapping("/evenement/{idEvenement}")
	@JsonView(JsonViews.ReservationWithEvenements.class)
	public List<Reservation> getByIdEvenement(@PathVariable("idEvenement")Long idEvenement){
		return reservationSrv.getByEvenementId(idEvenement);
	}
	
	
}

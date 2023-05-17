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

import salleDeConcert.entities.Client;
import salleDeConcert.entities.jsonviews.JsonViews;
import salleDeConcert.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	@Autowired
	private ClientService clientSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Client.class)
	public List<Client> getAll() {
		return clientSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client getById(@PathVariable("id") Long id) {
		return clientSrv.getById(id);
	}
	
	@GetMapping("/{id}/reservations")
	@JsonView(JsonViews.ClientWithReservations.class)
	public Client getByIdWithReservations(@PathVariable("id") Long id) {
		return clientSrv.getByIdWithReservations(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Client.class)
	public Client create(@Valid @RequestBody Client client,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return clientSrv.create(client);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Client.class)
	public Client update(@Valid @RequestBody Client client,BindingResult br,@PathVariable Long id) {
		client.setId(id);
		return clientSrv.update(client);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clientSrv.delete(id);
	}
}

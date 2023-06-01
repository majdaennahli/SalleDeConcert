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

import projetFinal.salleDeConcert.entities.Staff;
import projetFinal.salleDeConcert.entities.jsonviews.JsonViews;
import projetFinal.salleDeConcert.services.StaffService;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "*")
public class StaffRestController {
	
	@Autowired
	private StaffService staffSrv;
	
	@GetMapping("")
	@JsonView(JsonViews.Staff.class)
	public List<Staff> getAll(){
		return staffSrv.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Staff.class)
	public Staff getById(@PathVariable("id") Long id) {
		return staffSrv.getById(id);
	}
	

	@GetMapping("/{id}/evenements")
	@JsonView(JsonViews.StaffWithEvenements.class)
	public Staff getByIdWithEvenements(@PathVariable("id") Long id) {
		return staffSrv.getByIdWithEvenements(id);
	}
	
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Staff.class)
	public Staff create(@Valid @RequestBody Staff staff,BindingResult br) {
		if(br.hasErrors()) {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return staffSrv.create(staff);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Staff.class)
	public Staff update(@Valid @RequestBody Staff staff,BindingResult br,@PathVariable Long id) {
		staff.setId(id);
		return staffSrv.update(staff);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		staffSrv.delete(id);
	}
	
}

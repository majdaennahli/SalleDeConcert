package projetFinal.salleDeConcert.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFinal.salleDeConcert.entities.Staff;
import projetFinal.salleDeConcert.exceptions.EvenementException;
import projetFinal.salleDeConcert.exceptions.StaffException;
import projetFinal.salleDeConcert.repositories.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepo;

	private void checkStaff(Staff staff) {
		if (staff == null) {
			throw new StaffException("staff null");
		}
		if (staff.getNom() == null || staff.getNom().isEmpty()) {
			throw new StaffException("nom obligatoire");
		}
	}

	public List<Staff> getAll() {
		return staffRepo.findAll();
	}

	private void checkId(Long id) {
		if (id == null) {
			throw new StaffException("id null");
		}
	}

	public Staff getById(Long id) {
		checkId(id);
		return staffRepo.findById(id).orElseThrow(() -> {
			throw new StaffException("id inconnu");
		});
	}
	public Staff getByIdWithEvenements(Long id) {
		checkId(id);
		return staffRepo.findByIdFetchEvenements(id).orElseThrow(() -> {
			throw new StaffException("id inconnu");
		});	}

	public Staff create(Staff staff) {
		checkStaff(staff);
		return staffRepo.save(staff);
	}

	public Staff update(Staff staff) {
		Staff staffEnBase = getById(staff.getId());
		checkStaff(staff);
		staffEnBase.setNom(staff.getNom());
		staffEnBase.setEvenements(staff.getEvenements());
		return staffRepo.save(staffEnBase);
	}

	public void delete(Staff staff) {
		delete(staff.getId());
	}

	public void delete(Long id) {
		Staff staffEnBase = getById(id);
		staffRepo.delete(staffEnBase);
	}
}

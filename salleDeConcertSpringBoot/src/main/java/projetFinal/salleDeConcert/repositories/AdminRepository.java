package projetFinal.salleDeConcert.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFinal.salleDeConcert.entities.Admin;



public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	
	Optional <Admin> findByLogin(String login);
	
	
	
}

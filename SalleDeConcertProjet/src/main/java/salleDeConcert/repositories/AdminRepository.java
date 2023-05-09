package salleDeConcert.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import salleDeConcert.entities.Admin;
import salleDeConcert.entities.Client;


public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	
	
	
	
	
}

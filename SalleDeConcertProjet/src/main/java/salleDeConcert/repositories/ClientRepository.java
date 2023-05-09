package salleDeConcert.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import salleDeConcert.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {
	
	
	@Query("from Client c left join fetch c.reservations where c.id=:id")
	Optional<Client>  findByIdFetchReservations(@Param("id") Long id);
	
	
	List<Client> findByNom(String nom);
	
	List<Client> findByNomContaining(String nom);
	
	@Query("select c from Client c where timestampdiff(year,c.naissance,current_date)<18")
	Optional<List<Client>> findMineur();
	
	@Query("select c from Client c where timestampdiff(year,c.naissance,current_date)>=18")
	Optional <List<Client>> findMajeur();
	
	
	
	
}

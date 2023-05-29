package projetFinal.salleDeConcert.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFinal.salleDeConcert.entities.Local;



public interface LocalRepository extends JpaRepository<Local, Long> {
	
	List<Local> findByNom(String nom);
	
	@Query("from Local l left join fetch l.evenements where l.id=:id")
	Optional <Local> findByIdFetchEvenements(@Param("id") Long id);

	
	
	
	
}

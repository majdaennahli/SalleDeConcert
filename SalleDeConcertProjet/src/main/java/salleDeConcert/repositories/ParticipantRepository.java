package salleDeConcert.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import salleDeConcert.entities.Participant;
import salleDeConcert.entities.Reduc;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	
	List<Participant> findByNom(String nom);
	
	List<Participant> findByReduc(Reduc reduc);
	
	List<Participant> findById(int id);
	
	@Query("from Participant p left join fetch p.reservations r  where r.evenement.id=:id")
	Optional<Participant>  findByIdEvenement(@Param("id") Long id);
	
	//compter nombre de participants par evenement ??
	@Query("select count(p.id) from participant p left join p.reservations r left join r.evenements where e.id=:id ")
	Optional<Participant> countByEvenements(@Param("id") Long id);
	
	
	
	
}

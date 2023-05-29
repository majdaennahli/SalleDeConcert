package projetFinal.salleDeConcert.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFinal.salleDeConcert.entities.Participant;
import projetFinal.salleDeConcert.entities.Reduc;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
	
	List<Participant> findByNom(String nom);
	
	List<Participant> findByReduc(Reduc reduc);
	
	List<Participant> findById(int id);
	
	@Query("from Participant p left join fetch p.reservations r  where r.evenement.id=:id")
	List<Participant>  findByIdEvenement(@Param("id") Long id);
	
//	@Query("select count(p.id) from participant p left join p.reservations r left join r.evenements where e.id=:id ")
//	Long countByEvenements(@Param("id") Long id);
	
	
	
	
}

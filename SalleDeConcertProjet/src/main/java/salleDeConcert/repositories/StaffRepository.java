package salleDeConcert.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import salleDeConcert.entities.Staff;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import salleDeConcert.entities.Evenement;
import salleDeConcert.entities.Reservation;




public interface StaffRepository extends JpaRepository<Staff, Long> {
	
	
	List<Staff> findByNom(String nom);
	
	List<Staff> findByEvenements(Set<Evenement> evenements);
	
	@Query("from Staff s left join fetch s.evenements where s.id=:id")
	Optional <Staff> findByIdFetchEvenements(@Param("id") Long id);

	
}

package salleDeConcert.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import salleDeConcert.entities.Staff;




public interface StaffRepository extends JpaRepository<Staff, Long> {
	
	
	List<Staff> findByNom(String nom);
	
	@Query("from Staff s left join fetch s.evenements where s.id=:id")
	Optional <Staff> findByIdFetchEvenements(@Param("id") Long id);

}

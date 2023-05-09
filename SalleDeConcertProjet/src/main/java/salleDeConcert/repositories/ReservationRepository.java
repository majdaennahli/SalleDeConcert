package salleDeConcert.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import salleDeConcert.entities.Client;
import salleDeConcert.entities.Evenement;
import salleDeConcert.entities.Local;
import salleDeConcert.entities.Reservation;




public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	
	List<Reservation> findByDateReserv(LocalDate dateReserv);
	
	List<Reservation> findByClient(Client client);
	
	List<Reservation> findByEvenement(Evenement evenement);
	
	@Query("from Reservation r left join fetch r.participants where r.id=:id")
	Optional <Reservation> findByIdFetchParticipants(@Param("id") Long id);

	//Verifier nombre de places dispo avant de faire une resa

}

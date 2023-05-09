package salleDeConcert.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import salleDeConcert.entities.Artiste;
import salleDeConcert.entities.Evenement;
import salleDeConcert.entities.Local;
import salleDeConcert.entities.TypeEvenement;



public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	
	
	List<Evenement> findByNom(String nom);
	
	List<Evenement> findByNomContaining(String nom);
	
	@Query("from Evenement e left join fetch e.artistes a where a.nomArtiste=:nomArtiste")
	Optional<Evenement>  findByNomArtiste(@Param("nomArtiste") String nomArtiste);
	
	List <Artiste> findByArtiste (Artiste artiste);
	
	List<Evenement> findByTypeEvenement(TypeEvenement typeEvenement);
	
	@Query("from Evenement e where e.typeEvenement=:typeEvenement and e.dateDebut>=CURRENT_DATE()")
	Optional<Evenement> findByTypeEvenementToCome(@Param("typeEvenement")TypeEvenement typeEvenement);
	
	@Query("from Evenement e where e.typeEvenement=:typeEvenement and e.dateDebut=:dateDebut")
	Optional<Evenement> findByTypeEvenementAndDate(@Param("typeEvenement")TypeEvenement typeEvenement,@Param("dateDebut") LocalDate dateDebut);


	List<Evenement> findByDateDebut(LocalDate dateDebut);
	
	List<Evenement> findByDateFin(LocalDate dateFin);
	
	@Query("select timestampdiff(day,e.dateDebut,e.dateFin) from Evenement e ")
	Optional<LocalDate> findDureeJours(Long id);
	
	@Query("select timediff(e.heureFin,e.heureDebut) from Evenement e where e.dateDebut=e.dateFin")
	Optional<LocalDate> findDureeHeures(Long id);
	
	List<Evenement> findByLocal(Local local);
	
	
	@Query("from Evenement e left join fetch e.staffs s where e.id=:id")
	Optional<Evenement> findByIdFetchStaffs(@Param("id") Long id);
}

package projetFinal.salleDeConcert.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFinal.salleDeConcert.entities.Artiste;




public interface ArtisteRepository extends JpaRepository<Artiste, Long> {
	
	
	List <Artiste> findByNomArtiste(String nomArtiste);
	
	@Query("from Artiste a left join fetch a.evenements e where a.id=:id")
	Optional<Artiste> findByIdFetchEvenements(@Param("id") Long id);
	
	List<Artiste> findByNomArtisteContaining(String nomArtiste);	
}

package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PaysDao extends JpaRepository<Pays, String> {

    @Query("""
			FROM Pays p
			WHERE size(p.clients)=0
			""")
    List<Pays> findCountriesWithoutCustomers();

    @Query("""
			FROM Pays p
			ORDER BY size(p.clients) DESC
			""")
    List<Pays> findCountriesOrderedByNbOfCustomersDesc();

    @Query("""
			FROM Pays p
			ORDER BY rand()
			""")
    List<Pays> findAllShuffled();

    // Renvoie les pays sans clients
    List<Pays> findByClientsIsEmpty();

    Pays findByCode(String code);
}

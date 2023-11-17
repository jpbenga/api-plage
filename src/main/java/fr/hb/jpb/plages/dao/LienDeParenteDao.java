package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.LienDeParente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LienDeParenteDao extends JpaRepository<LienDeParente, Long> {
    LienDeParente findByNom(String nom);
}

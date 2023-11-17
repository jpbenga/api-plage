package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutDao extends JpaRepository<Statut, Long> {
    Statut findByNom(String nom);
}

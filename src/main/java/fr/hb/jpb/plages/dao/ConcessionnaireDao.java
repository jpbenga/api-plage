package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.Concessionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionnaireDao extends JpaRepository<Concessionnaire, Long> {
}

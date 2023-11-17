package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EquipementDao extends JpaRepository<Equipement, Long> {
}

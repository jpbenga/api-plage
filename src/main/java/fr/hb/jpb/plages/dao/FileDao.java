package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDao extends JpaRepository<File, Long> {
}

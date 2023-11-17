package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.Parasol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParasolDao extends JpaRepository<Parasol, Long> {

    Page<Parasol> findByFileId(Pageable pageable, Long idFile);
}

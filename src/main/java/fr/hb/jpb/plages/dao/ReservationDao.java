package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long> {

    @Query("""
            FROM Reservation
            WHERE WEEK(dateDebut) = WEEK(current_date())
            """)    List<Reservation> findAllByCurrentWeek();
}

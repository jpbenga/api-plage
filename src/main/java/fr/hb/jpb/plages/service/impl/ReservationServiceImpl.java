package fr.hb.jpb.plages.service.impl;

import fr.hb.jpb.plages.business.Reservation;
import fr.hb.jpb.plages.dao.ReservationDao;
import fr.hb.jpb.plages.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao;

    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    @Override
    public List<Reservation> recupererReservations() {
        return reservationDao.findAll();
    }

    @Override
    public Reservation recupererReservation(Long id) {
        return reservationDao.findById(id).orElse(null);
    }

    @Override
    public Reservation mettreAJourReservation(Reservation reservation) {
        // Implémentez la logique de mise à jour selon vos besoins
        return reservationDao.save(reservation);
    }

    @Override
    public boolean supprimerReservation(Long id) {
        Reservation reservation = recupererReservation(id);
        if (reservation != null) {
            reservationDao.delete(reservation);
            return true;
        }
        return false;
    }
}

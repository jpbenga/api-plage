package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.business.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {

    Reservation ajouterReservation(Reservation reservation);

    List<Reservation> recupererReservations();

    Reservation recupererReservation(Long id);

    Reservation mettreAJourReservation(Reservation reservation);

    boolean supprimerReservation(Long id);
}

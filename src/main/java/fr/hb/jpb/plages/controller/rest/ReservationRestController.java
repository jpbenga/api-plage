package fr.hb.jpb.plages.controller.rest;

import fr.hb.jpb.plages.business.Reservation;
import fr.hb.jpb.plages.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationRestController {

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        return reservationService.recupererReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.recupererReservation(id);
    }

    @PostMapping
    public Reservation postReservation(@Valid @RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping
    public Reservation putReservation(@Valid @RequestBody Reservation reservation) {
        return reservationService.mettreAJourReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public boolean deleteReservation(@PathVariable Long id) {
        return reservationService.supprimerReservation(id);
    }
}

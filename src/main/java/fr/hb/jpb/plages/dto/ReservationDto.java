package fr.hb.jpb.plages.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDto {

    Long id;
    LocalDate dateDebut;
    LocalDate dateFin;
    double montantARegler;
    String remarques;
    String numeroCarte;
    byte moisExpiration;
    byte anneeExpiration;
    String cryptogramme;
    int version;
    StatutDto statutDto;
    ClientDto clientDto;
    List<ParasolDto> parasols;

}

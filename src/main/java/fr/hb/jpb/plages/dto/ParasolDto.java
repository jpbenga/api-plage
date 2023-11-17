package fr.hb.jpb.plages.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParasolDto {

    Long id;
    Byte numEmplacement;
    FileDto fileDto;
    List<ReservationDto> reservations;
}

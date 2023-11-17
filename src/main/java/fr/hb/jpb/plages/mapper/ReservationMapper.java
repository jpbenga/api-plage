package fr.hb.jpb.plages.mapper;

import fr.hb.jpb.plages.business.Reservation;
import fr.hb.jpb.plages.dto.ReservationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {StatutMapper.class, ClientMapper.class, ParasolMapper.class})
public interface ReservationMapper {

    @Mapping(source = "statut", target = "statutDto")
    @Mapping(source = "client", target = "clientDto")
    ReservationDto toDto(Reservation reservation);

    @Mapping(source = "statutDto", target = "statut")
    @Mapping(source = "clientDto", target = "client")
    Reservation toEntity(ReservationDto reservationDto);

}

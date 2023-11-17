package fr.hb.jpb.plages.mapper;

import fr.hb.jpb.plages.business.Parasol;
import fr.hb.jpb.plages.dto.ParasolDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {FileMapper.class, ReservationMapper.class})
public interface ParasolMapper {

    @Mapping(source = "file", target = "fileDto")
    ParasolDto toDto(Parasol parasol);

    @Mapping(source = "fileDto", target = "file")
    Parasol toEntity(ParasolDto parasolDto);

    List<ParasolDto> mapParasols(List<Parasol> parasols);

    List<Parasol> mapParasolDtos(List<ParasolDto> parasolDtos);
}

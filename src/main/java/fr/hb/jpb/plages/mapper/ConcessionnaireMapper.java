package fr.hb.jpb.plages.mapper;

import fr.hb.jpb.plages.business.Concessionnaire;
import fr.hb.jpb.plages.dto.ConcessionnaireDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ConcessionnaireMapper {

    ConcessionnaireMapper INSTANCE = Mappers.getMapper(ConcessionnaireMapper.class);

    ConcessionnaireDto toDto(Concessionnaire concessionnaire);

    Concessionnaire toEntity(ConcessionnaireDto concessionnaireDto);

}

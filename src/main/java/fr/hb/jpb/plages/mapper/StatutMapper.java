package fr.hb.jpb.plages.mapper;

import fr.hb.jpb.plages.business.Statut;
import fr.hb.jpb.plages.dto.StatutDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StatutMapper {

    StatutDto toDto(Statut statut);

    Statut toEntity(StatutDto statutDto);

}

package fr.hb.jpb.plages.mapper;

import fr.hb.jpb.plages.business.LienDeParente;
import fr.hb.jpb.plages.dto.LienDeParenteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LienDeParenteMapper {

    LienDeParenteMapper INSTANCE = Mappers.getMapper(LienDeParenteMapper.class);

    LienDeParenteDto toDto(LienDeParente lienDeParente);

    LienDeParente toEntity(LienDeParenteDto lienDeParenteDto);

}

package fr.hb.jpb.plages.mapper;

import fr.hb.jpb.plages.business.Client;
import fr.hb.jpb.plages.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { PaysMapper.class, LienDeParenteMapper.class })
public interface ClientMapper {

    @Mapping(source = "paysDto", target = "pays")
    @Mapping(source = "lienDeParenteDto", target = "lienDeParente")
    @Mapping(target = "reservations", ignore = true)
    @Mapping(target = "dateHeureInscription", ignore = true)
    Client toEntity(ClientDto clientDto);

    @Mapping(source = "pays", target = "paysDto")
    @Mapping(source = "lienDeParente", target = "lienDeParenteDto")
    ClientDto toDto(Client client);

}

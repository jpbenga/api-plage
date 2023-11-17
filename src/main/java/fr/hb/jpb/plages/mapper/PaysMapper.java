package fr.hb.jpb.plages.mapper;

import fr.hb.jpb.plages.business.Pays;
import fr.hb.jpb.plages.dto.PaysDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaysMapper {

    /**
     * Méthode qui convertit un métier en Dto
     *
     * @param pays
     * @return un objet Dto
     */
    PaysDto toDto(Pays pays);

    /**
     * Méthode qui convertit un Dto en métier
     *
     * @param paysDto
     * @return un objet métier
     */
    @Mapping(target = "clients", ignore = true)
    @Mapping(target = "nbClients", ignore = true)
    Pays toEntity(PaysDto paysDto);

}

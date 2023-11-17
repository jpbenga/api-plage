package fr.hb.jpb.plages.mapper;

import fr.hb.jpb.plages.business.File;
import fr.hb.jpb.plages.dto.FileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ParasolMapper.class)
public interface FileMapper {

    @Mapping(target = "parasols", ignore = true)
    FileDto toDto(File file);

    File toEntity(FileDto fileDto);

    List<FileDto> toDtoList(List<File> files);

    List<File> toEntityList(List<FileDto> fileDtos);
}

package fr.hb.jpb.plages.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileDto {

    Long id;
    Byte numero;
    Double prixJournalier;
    List<ParasolDto> parasols;
}

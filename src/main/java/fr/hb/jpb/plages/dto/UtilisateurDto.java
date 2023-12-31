package fr.hb.jpb.plages.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UtilisateurDto {

    Long id;
    String nom;
    String prenom;
    String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String motDePasse;

    String type;

}

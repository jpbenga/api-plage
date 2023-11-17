package fr.hb.jpb.plages.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Parasol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Merci de renseigner le numéro d'emplacement")
    @Range(min = 1, max = 36, message ="Merci de préciser une file comprise entre {min} et {max}")
    private Byte numEmplacement;

    @ManyToOne
    @JsonIgnore
    @NotNull(message = "merci de choisr une file")
    private File file;

    @ToString.Exclude
    @OneToMany(mappedBy = "parasols", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    public Parasol(byte numEmplacement, File file) {
        super();
        this.numEmplacement = numEmplacement;
        this.file = file;
    }

    @JsonIgnore
    public String getNumeroDeLaFile() {
        return String.valueOf(file.getNumero());
    }

    public String getNumeroEmplacementEtNumeroDeFile() {
        return numEmplacement + " en file " + file.getNumero();
    }
}

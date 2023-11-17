package fr.hb.jpb.plages.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Byte numero;
    private Double prixJournalier;

    @OneToMany(mappedBy = "file")
    @ToString.Exclude
    @JsonIgnore
    private List<Parasol> parasols;

    public File(byte numero, double prixJournalier) {
        super();
        this.numero = numero;
        this.prixJournalier = prixJournalier;
    }

}

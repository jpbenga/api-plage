package fr.hb.jpb.plages.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    private EquipementType equipementType;

    @ManyToOne
    @JsonIgnore
    private Parasol parasol;

    @OneToMany(mappedBy = "equipement", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Reservation> reservations;
}

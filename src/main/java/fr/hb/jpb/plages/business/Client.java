package fr.hb.jpb.plages.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Client extends Utilisateur{

    @Column(updatable = false)
    private LocalDateTime dateHeureInscription;

    @ManyToOne
    @JsonIgnore
    private LienDeParente lienDeParente;

    @ManyToOne
    @JsonIgnore
    private Pays pays;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reservation> reservations;

}

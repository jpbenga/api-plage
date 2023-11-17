package fr.hb.jpb.plages.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double montantARegler;
    private String remarques;
    private String numeroCarte;
    private byte moisExpiration;
    private byte anneeExpiration;
    private String cryptogramme;
    private int version;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Statut statut;

    @ManyToOne
    @JsonIgnore
    private Client client;

    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    private List<Parasol> parasols;

    @OneToOne
    @JsonIgnore
    private Equipement equipement;
}

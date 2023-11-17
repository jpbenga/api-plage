package fr.hb.jpb.plages.business;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LienDeParente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private float coefficient;

    //Relation
    @OneToMany(mappedBy="lienDeParente")
    private List<Client> clients;

    public LienDeParente(String typeDeParente, float coefficient) {
        this();
        this.nom = typeDeParente;
        this.coefficient = coefficient;
    }
}

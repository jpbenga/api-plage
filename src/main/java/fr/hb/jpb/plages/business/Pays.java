package fr.hb.jpb.plages.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pays {

    @Id
    private String code;

    private String nom;

    @OneToMany(mappedBy = "pays", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private List<Client> clients;

    @Transient
    @JsonIgnore
    private int nbClients;

    public Pays(String code, String nom){
        this.code = code;
        this.nom = nom;
    }
}

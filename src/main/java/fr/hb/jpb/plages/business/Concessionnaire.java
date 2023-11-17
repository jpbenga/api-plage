package fr.hb.jpb.plages.business;

import lombok.*;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Concessionnaire extends Utilisateur{

    private String numeroDeTelephone;
}

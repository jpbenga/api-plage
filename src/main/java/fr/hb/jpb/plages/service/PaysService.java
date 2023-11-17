package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.business.Pays;
import fr.hb.jpb.plages.dto.PaysDto;

import java.util.List;

public interface PaysService {

    List<Pays> recupererPays();

    Pays ajouterPays(String code, String nom);

    Pays mettreAJour(String code, String nouveauNom);

    Pays recupererPays(String code);

    Pays enregistrerPays(Pays pays);

    boolean supprimerPays(String code);

    Pays enregistrerPays(PaysDto paysDto);

}

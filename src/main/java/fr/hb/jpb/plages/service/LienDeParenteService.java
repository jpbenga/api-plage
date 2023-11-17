package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.business.LienDeParente;

import java.util.List;

public interface LienDeParenteService {

    List<LienDeParente> recupererLiensDeParente();

    LienDeParente recupererLienDeParente(Long id);

    LienDeParente ajouterLienDeParente(String nom, float coefficient);

    LienDeParente enregistrerLienDeParente(LienDeParente lienDeParente);

    boolean supprimerLienDeParente(LienDeParente lienDeParente);

}

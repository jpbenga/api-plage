package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.business.Concessionnaire;

import java.util.List;

public interface ConcessionnaireService {

    Concessionnaire enregistrerConcessionnaire(Concessionnaire concessionnaire);
    Concessionnaire recupererConcessionnaire(Long id);
    List<Concessionnaire> recupererConcessionnaires();

    boolean supprimerConcessionnaire(Long id);

}

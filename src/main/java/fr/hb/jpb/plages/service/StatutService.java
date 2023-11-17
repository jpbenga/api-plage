package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.business.Statut;

import java.util.List;

public interface StatutService {
    Statut ajouterStatut(Statut statut);

    List<Statut> recupererStatuts();

    Statut recupererStatut(Long id);

    Statut mettreAJourStatut(Statut statut);

    boolean supprimerStatut(Long id);

    // Vous pouvez ajouter d'autres méthodes si nécessaire
}

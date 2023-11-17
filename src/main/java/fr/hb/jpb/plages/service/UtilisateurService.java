package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.business.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UtilisateurService {
    Utilisateur recupererUtilisateur(Long id);
    Utilisateur enregistrerUtilisateur(Utilisateur utilisateur);

    List<Utilisateur> recupererUtilisateurs();

    Utilisateur ajouterClientAleatoire();
    Utilisateur recupererUtilisateurParEmailMotDePasse(String email, String motDepasse);
    Page <Utilisateur> recupererUtilisateurs(Pageable pageable);
}

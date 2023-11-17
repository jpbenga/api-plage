package fr.hb.jpb.plages.dao;

import fr.hb.jpb.plages.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
}

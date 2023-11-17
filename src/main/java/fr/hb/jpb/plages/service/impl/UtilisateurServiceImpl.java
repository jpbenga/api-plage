package fr.hb.jpb.plages.service.impl;

import fr.hb.jpb.plages.business.Utilisateur;
import fr.hb.jpb.plages.dao.UtilisateurDao;
import fr.hb.jpb.plages.service.UtilisateurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurDao utilisateurDao;

    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @Override
    public List<Utilisateur> recupererUtilisateurs() {
        return utilisateurDao.findAll();
    }

    @Override
    public Utilisateur ajouterClientAleatoire() {
        return null;
    }

    @Override
    public Utilisateur recupererUtilisateurParEmailMotDePasse(String email, String motDepasse) {
        return null;
    }

    @Override
    public Page<Utilisateur> recupererUtilisateurs(Pageable pageable) {
        return null;
    }

    @Override
    public Utilisateur recupererUtilisateur(Long id) {
        return utilisateurDao.findById(id).orElse(null);
    }

    @Override
    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
        return null;
    }

}

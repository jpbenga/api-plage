package fr.hb.jpb.plages.service.impl;

import fr.hb.jpb.plages.business.Statut;
import fr.hb.jpb.plages.dao.StatutDao;
import fr.hb.jpb.plages.service.StatutService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatutServiceImpl implements StatutService {

    private final StatutDao statutDao;

    @Override
    public Statut ajouterStatut(Statut statut) {
        return statutDao.save(statut);
    }

    @Override
    public List<Statut> recupererStatuts() {
        return statutDao.findAll();
    }

    @Override
    public Statut recupererStatut(Long id) {
        return statutDao.findById(id).orElse(null);
    }

    @Override
    public Statut mettreAJourStatut(Statut statut) {
        // Assurez-vous que le statut existe avant de le mettre à jour
        if (statutDao.existsById(statut.getId())) {
            return statutDao.save(statut);
        }
        return null;
    }

    @Override
    public boolean supprimerStatut(Long id) {
        // Supprime le statut s'il existe
        if (statutDao.existsById(id)) {
            statutDao.deleteById(id);
            return true;
        }
        return false;
    }
}

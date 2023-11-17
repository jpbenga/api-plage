package fr.hb.jpb.plages.service.impl;


import fr.hb.jpb.plages.business.Pays;
import fr.hb.jpb.plages.dao.PaysDao;
import fr.hb.jpb.plages.dto.PaysDto;
import fr.hb.jpb.plages.exception.PaysExistantException;
import fr.hb.jpb.plages.service.PaysService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaysServiceImpl implements PaysService {

    private final PaysDao paysDao;

    @Override
    public List<Pays> recupererPays() {
        return paysDao.findAll();
    }

    /**
     * Cette méthode ajoute un nouveau pays en utilisant le code et le nom donnés en paramètre
     *
     * si le code est déjà présent en base, la méthode lève une exception PaysExistantException
     *
     */
    @Override
    public Pays ajouterPays(String code, String nom) {
        if (paysDao.findByCode(code)==null) {
            return paysDao.save(new Pays(code, nom));
        }
        else {
            throw new PaysExistantException("Ce pays existe déjà");
        }
    }

    @Override
    public Pays mettreAJour(String code, String nouveauNom) {
        Pays pays = paysDao.findByCode(code);
        if (pays != null) {
            pays.setNom(nouveauNom);
            return paysDao.save(pays);
        }
        else {
            // C'est le rôle des services de lever des exceptions maison
            throw new PaysExistantException("Pays inexistant");
        }
    }

    @Override
    public Pays recupererPays(String code) {
        return paysDao.findByCode(code.toUpperCase());
    }

    @Override
    public Pays enregistrerPays(Pays pays) {
        return paysDao.save(pays);
    }

    @Override
    public boolean supprimerPays(String code) {
        Pays pays = recupererPays(code);
        if (pays!=null) {
            paysDao.delete(pays);
            return true;
        }
        return false;
    }

    // TODO utiliser mapstruct pour faire cette conversion
    @Override
    public Pays enregistrerPays(PaysDto paysDto) {
        Pays pays = new Pays();
        pays.setCode(paysDto.getCode());
        pays.setNom(paysDto.getNom());
        return paysDao.save(pays);
    }

}

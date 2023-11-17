package fr.hb.jpb.plages.service.impl;

import fr.hb.jpb.plages.business.LienDeParente;
import fr.hb.jpb.plages.dao.LienDeParenteDao;

import fr.hb.jpb.plages.service.LienDeParenteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LienDeParenteServiceImpl implements LienDeParenteService {

    private LienDeParenteDao lienDeParenteDao;

    @Override
    public List<LienDeParente> recupererLiensDeParente() {
        return lienDeParenteDao.findAll();
    }

    @Override
    public LienDeParente recupererLienDeParente(Long id) {
        return lienDeParenteDao.findById(id).orElse(null);
    }

    @Override
    public LienDeParente ajouterLienDeParente(String nom, float coefficient) {
        return lienDeParenteDao.save(new LienDeParente(nom, coefficient));
    }

    @Override
    public LienDeParente enregistrerLienDeParente(LienDeParente lienDeParente) {
        return lienDeParenteDao.save(lienDeParente);
    }

    public boolean supprimerLienDeParente(LienDeParente lienDeParente){
        if(lienDeParente != null){
            lienDeParenteDao.delete(lienDeParente);
            return true;
        }
        return false;
    }

}

package fr.hb.jpb.plages.service.impl;

import fr.hb.jpb.plages.business.Concessionnaire;
import fr.hb.jpb.plages.dao.ConcessionnaireDao;
import fr.hb.jpb.plages.service.ConcessionnaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConcessionnaireServiceImpl implements ConcessionnaireService {

    private final ConcessionnaireDao concessionnaireDao;

    @Override
    public List<Concessionnaire> recupererConcessionnaires() {
        return concessionnaireDao.findAll();
    }

    @Override
    public Concessionnaire recupererConcessionnaire(Long id) {
        return concessionnaireDao.findById(id).orElse(null);
    }

    @Override
    public Concessionnaire enregistrerConcessionnaire(Concessionnaire concessionnaire) {
        return concessionnaireDao.save(concessionnaire);
    }

    @Override
    public boolean supprimerConcessionnaire(Long id) {
        Concessionnaire concessionnaire = recupererConcessionnaire(id);
        if (concessionnaire != null) {
            concessionnaireDao.delete(concessionnaire);
            return true;
        }
        return false;
    }
}

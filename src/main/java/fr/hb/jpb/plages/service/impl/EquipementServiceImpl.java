package fr.hb.jpb.plages.service.impl;

import fr.hb.jpb.plages.business.Equipement;
import fr.hb.jpb.plages.business.EquipementType;
import fr.hb.jpb.plages.dao.EquipementDao;
import fr.hb.jpb.plages.service.EquipementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipementServiceImpl implements EquipementService {

    private final EquipementDao equipementDao;

    @Override
    public Equipement recupererEquipement(Long id) {
        return equipementDao.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> recupererEquipements() {
        return equipementDao.findAll();
    }

    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementDao.save(equipement);
    }

    @Override
    public Equipement modifierEquipement(Long id, EquipementType type) {
        Equipement equipementExistant = equipementDao.findById(id).orElse(null);

        if (equipementExistant != null) {
            equipementExistant.setEquipementType(type);
            return equipementDao.save(equipementExistant);
        } else {
            // Gérer le cas où l'équipement avec l'ID spécifié n'est pas trouvé.
            return null;
        }
    }

    @Override
    public boolean supprimerEquipement(Long id) {
        // Supprime l'équipement s'il existe
        if (equipementDao.existsById(id)) {
            equipementDao.deleteById(id);
            return true;
        }
        return false;
    }
}


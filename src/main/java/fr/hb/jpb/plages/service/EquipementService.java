package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.business.Equipement;
import fr.hb.jpb.plages.business.EquipementType;

import java.util.List;

public interface EquipementService {

    Equipement recupererEquipement(Long id);

    List<Equipement> recupererEquipements();

    Equipement ajouterEquipement(Equipement nouvelEquipement);

    Equipement modifierEquipement(Long id, EquipementType type);

    boolean supprimerEquipement(Long id);

}

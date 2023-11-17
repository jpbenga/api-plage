package fr.hb.jpb.plages.controller.rest;

import fr.hb.jpb.plages.business.Equipement;
import fr.hb.jpb.plages.business.EquipementType;
import fr.hb.jpb.plages.service.EquipementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementRestController {

    private final EquipementService equipementService;

    public EquipementRestController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @GetMapping
    public List<Equipement> recupererEquipements() {
        return equipementService.recupererEquipements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> recupererEquipement(@PathVariable Long id) {
        Equipement equipement = equipementService.recupererEquipement(id);
        if (equipement != null) {
            return ResponseEntity.ok(equipement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement ajouterEquipement(@Valid @RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> modifierEquipement(@PathVariable Long id, @Valid @RequestBody EquipementType type) {
        Equipement equipementModifie = equipementService.modifierEquipement(id, type);

        if (equipementModifie != null) {
            return ResponseEntity.ok(equipementModifie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEquipement(@PathVariable Long id) {
        boolean suppressionReussie = equipementService.supprimerEquipement(id);
        if (suppressionReussie) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

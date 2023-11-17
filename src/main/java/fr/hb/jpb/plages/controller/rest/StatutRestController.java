package fr.hb.jpb.plages.controller.rest;

import fr.hb.jpb.plages.business.Statut;
import fr.hb.jpb.plages.service.StatutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuts")
public class StatutRestController {

    private final StatutService statutService;

    public StatutRestController(StatutService statutService) {
        this.statutService = statutService;
    }

    @GetMapping
    public List<Statut> getAllStatuts() {
        return statutService.recupererStatuts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statut> getStatutById(@PathVariable Long id) {
        Statut statut = statutService.recupererStatut(id);
        return statut != null ? ResponseEntity.ok(statut) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Statut createStatut(@RequestParam String nom) {
        Statut statut = new Statut(nom);
        return statutService.ajouterStatut(statut);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statut> updateStatut(@PathVariable Long id, @RequestParam String nom) {
        Statut existingStatut = statutService.recupererStatut(id);

        if (existingStatut != null) {
            existingStatut.setNom(nom);
            statutService.ajouterStatut(existingStatut);
            return ResponseEntity.ok(existingStatut);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatut(@PathVariable Long id) {
        Statut statut = statutService.recupererStatut(id);
        if (statut != null) {
            statutService.supprimerStatut(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

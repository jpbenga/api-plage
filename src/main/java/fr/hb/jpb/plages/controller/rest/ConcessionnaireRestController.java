package fr.hb.jpb.plages.controller.rest;

import fr.hb.jpb.plages.business.Concessionnaire;
import fr.hb.jpb.plages.service.ConcessionnaireService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concessionnaires")
@AllArgsConstructor
@Validated
public class ConcessionnaireRestController {

    private final ConcessionnaireService concessionnaireService;

    @GetMapping
    public List<Concessionnaire> getConcessionnaires() {
        return concessionnaireService.recupererConcessionnaires();
    }

    @Operation(description = "Renvoie le concessionnaire dont l'id est donné en paramètre")
    @GetMapping("/{id}")
    public Concessionnaire getConcessionnaire(@PathVariable Long id) {
        return concessionnaireService.recupererConcessionnaire(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Concessionnaire postConcessionnaire(@RequestBody Concessionnaire concessionnaire) {
        return concessionnaireService.enregistrerConcessionnaire(concessionnaire);
    }

    @Operation(description = "Supprime le concessionnaire dont l'id est donné en paramètre")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConcessionnaire(@PathVariable Long id) {
        boolean deleted = concessionnaireService.supprimerConcessionnaire(id);
        if (deleted) {
            return ResponseEntity.ok("Concessionnaire supprimé avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Concessionnaire non trouvé.");
        }
    }
}

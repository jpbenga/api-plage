package fr.hb.jpb.plages.controller.rest;

import fr.hb.jpb.plages.business.LienDeParente;
import fr.hb.jpb.plages.service.LienDeParenteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/") // L'API des LienDeParente sera isolée sur une URL qui débute par api
public class LienDeParenteRestController {

    private LienDeParenteService lienDeParenteService;

    @PostMapping("lienParente/{nom}/{coefficient}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public LienDeParente postLienDeParente(@PathVariable String nom, @PathVariable float coefficient) {
        return lienDeParenteService.ajouterLienDeParente(nom, coefficient);
    }

    @GetMapping("liendeparente")
    public List<LienDeParente> getLiensDeParente() {
        return lienDeParenteService.recupererLiensDeParente();
    }

    @GetMapping("liendeparente/{id}")
    public LienDeParente getLienDeParente(@PathVariable Long id) {
        return lienDeParenteService.recupererLienDeParente(id);
    }

    @PutMapping("liendeparente/{id}/{nouveauNom}/{nouveauCoefficient}")
    public LienDeParente putLienDeParente(
            @PathVariable Long id,
            @PathVariable String nouveauNom,
            @PathVariable float nouveauCoefficient
    ) {
        LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);

        if (lienDeParente != null) {
            lienDeParente.setNom(nouveauNom);
            lienDeParente.setCoefficient(nouveauCoefficient);
            return lienDeParenteService.enregistrerLienDeParente(lienDeParente);
        } else {
            // Gérer le cas où l'id ne correspond à aucun lien de parenté existant
            // Vous pouvez lancer une exception ou retourner null, selon vos besoins.
            return null;
        }
    }

    @PatchMapping("liendeparente/{id}/{nouveauNom}")
    public LienDeParente patchLienDeParente(@PathVariable Long id, @PathVariable(name = "nouveauNom") String nom) {
        LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);
        lienDeParente.setNom(nom);
        return lienDeParenteService.enregistrerLienDeParente(lienDeParente);
    }

    @DeleteMapping("liendeparente/{id}")
    public boolean deleteLienDeParente(@PathVariable Long id) {
        LienDeParente lienDeParente = lienDeParenteService.recupererLienDeParente(id);
        return lienDeParenteService.supprimerLienDeParente(lienDeParente);
    }
}

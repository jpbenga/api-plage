package fr.hb.jpb.plages.controller.rest;

import fr.hb.jpb.plages.business.Utilisateur;
import fr.hb.jpb.plages.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
@Validated
public class UtilisateurRestController {

    private final UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.recupererUtilisateurs();
    }

    @GetMapping("/utilisateur")
    public Utilisateur getUtilisateur(@RequestParam(name = "id") Long id) {
        return utilisateurService.recupererUtilisateur(id);
    }
}


package fr.hb.jpb.plages.automate;

import fr.hb.jpb.plages.service.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@DependsOn("ajoutDonneesInitiales")
public class UtilisateurAutomate {

    private UtilisateurService utilisateurService;

    @Scheduled(cron = "* * * * * *")
    public void ajouterClientAleatoire() {

        utilisateurService.ajouterClientAleatoire();
    }
}
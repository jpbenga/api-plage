package fr.hb.jpb.plages.controller.rest;

import fr.hb.jpb.plages.business.Client;
import fr.hb.jpb.plages.dto.ClientDto;
import fr.hb.jpb.plages.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.recupererClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Long id) {
        return clientService.recupererClient(id);
    }

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client enregistrerClient(@Valid @RequestBody ClientDto clientDto, BindingResult result) {
        // Vérifier les erreurs de validation avec BindingResult si nécessaire

        return clientService.enregistrerClient(clientDto);
    }

    @PutMapping("/clients")
    public ResponseEntity<Client> mettreAJourClient(@Valid @RequestBody ClientDto clientDto) {
        if (clientDto.getId() != null) {
            Client client = clientService.enregistrerClient(clientDto);
            return ResponseEntity.status(200).body(client);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable Long id) {
        if (clientService.supprimerClient(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.business.Client;
import fr.hb.jpb.plages.business.Pays;
import fr.hb.jpb.plages.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ClientService {

     /**
      * La méthode renvoie une page de Client
      *
      * @param pageable qui correspond à une demande de page
      * @return une page de clients
      */
     Page<Client> recupererClients(Pageable pageable);

     Client recupererClient(Long idClient);

     Client enregistrerClient(ClientDto clientDto);

     List<Client> recupererClients();

     List<Client> recupererClients(Pays pays);

     boolean supprimerClient(Long id);
}
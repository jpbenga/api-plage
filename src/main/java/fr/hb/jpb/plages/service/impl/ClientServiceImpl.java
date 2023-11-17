package fr.hb.jpb.plages.service.impl;

import fr.hb.jpb.plages.business.Client;
import fr.hb.jpb.plages.business.Pays;
import fr.hb.jpb.plages.dao.ClientDao;
import fr.hb.jpb.plages.dto.ClientDto;
import fr.hb.jpb.plages.exception.ClientInexistantException;
import fr.hb.jpb.plages.exception.SuppressionClientImpossibleException;
import fr.hb.jpb.plages.mapper.ClientMapper;
import fr.hb.jpb.plages.service.ClientService;
import fr.hb.jpb.plages.service.LienDeParenteService;
import fr.hb.jpb.plages.service.PaysService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private final PaysService paysService;
    private final LienDeParenteService lienDeParenteService;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientDao clientDao, PaysService paysService,
                             LienDeParenteService lienDeParenteService, ClientMapper clientMapper) {
        this.clientDao = clientDao;
        this.paysService = paysService;
        this.lienDeParenteService = lienDeParenteService;
        this.clientMapper = clientMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Client> recupererClients(Pageable pageable) {
        return clientDao.findAll(pageable);
    }

    @Override
    public Client recupererClient(Long idClient) {
        return clientDao.findById(idClient).orElse(null);
    }

    @Override
    public Client enregistrerClient(ClientDto clientDto) {
        Client client = clientMapper.toEntity(clientDto);
        client.setPays(paysService.recupererPays(clientDto.getPaysDto().getCode()));
        client.setLienDeParente(lienDeParenteService.recupererLienDeParente(clientDto.getLienDeParenteDto().getId()));
        return clientDao.save(client);
    }

    @Override
    public boolean supprimerClient(Long id) {
        Client client = clientDao.findById(id)
                .orElseThrow(() -> new ClientInexistantException("Ce client n'existe pas"));
        if (!client.getReservations().isEmpty()) {
            throw new SuppressionClientImpossibleException("Le client ne peut être supprimé car il a effectué des réservations");
        }
        clientDao.delete(client);
        return true;
    }

    @Override
    public List<Client> recupererClients() {
        return clientDao.findAll();
    }

    @Override
    public List<Client> recupererClients(Pays pays) {
        return clientDao.findByPays(pays);
    }
}

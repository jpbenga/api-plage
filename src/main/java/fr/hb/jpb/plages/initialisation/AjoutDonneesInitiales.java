package fr.hb.jpb.plages.initialisation;

import com.github.javafaker.Faker;
import fr.hb.jpb.plages.business.*;
import fr.hb.jpb.plages.dao.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

    private FileDao fileDao;
    private ParasolDao parasolDao;
    private PaysDao paysDao;
    private LienDeParenteDao lienDeParenteDao;
    private ClientDao clientDao;
    private ConcessionnaireDao concessionnaireDao;
    private StatutDao statutDao;
    private ReservationDao reservationDao;
    private EquipementDao equipementDao;
    private static Double prixJour = 10D;

    @Override
    public void run(String... args) throws Exception {
        if(parasolDao.count() == 0){
            for (byte i = 1; i < 9; i++){
                File file = ajouterFiles(i);
                file.setPrixJournalier(prixJour);
                prixJour -= 1;
                file.setNumero(i);
                byte numeroEmplacement = 1;
                for (byte j = 0; j < 36; j++){
                    ajouterParasol(file, numeroEmplacement);
                    numeroEmplacement++;
                }
            }
        }

        ajouterPays();
        ajouterLiensDeParente();
        ajouterClients(10);
        ajouterConcessionnaire();
        ajouterStatuts();
        ajouterEquipements();
        ajouterReservations(20);

    }
    private File ajouterFiles(byte numero) {
         File file = new File();
         file.setNumero(numero);
         fileDao.save(file);
        return file;
    }

    private Parasol ajouterParasol(File file, byte numeroEmplacement){
        Parasol parasol = new Parasol();
        parasol.setFile(file);
        parasol.setNumEmplacement(numeroEmplacement);
        parasolDao.save(parasol);
        return parasol;
    }
    private void ajouterPays() {
        if (paysDao.count() == 0) {
            paysDao.saveAll(Arrays.asList(new Pays("FR", "France"), new Pays("IT", "Italie"), new Pays("GB", "Royaume-Uni"), new Pays("PT", "Portugal")));
        }
    }
    private void ajouterLiensDeParente() {
        if (lienDeParenteDao.count()==0) {
            lienDeParenteDao.save(new LienDeParente("Frère/Soeur", 0.5f));
            lienDeParenteDao.save(new LienDeParente("Cousin/Cousine", 0.75f));
            lienDeParenteDao.save(new LienDeParente("Aucun", 1f));
        }
    }

    private void ajouterEquipements(){
        if(equipementDao.count() == 0){
            equipementDao.saveAll(Arrays.asList(new Equipement(EquipementType.UN_LIT),
                    new Equipement(EquipementType.DEUX_LITS),
                    new Equipement(EquipementType.FAUTEUIL_ET_UN_LIT),
                    new Equipement(EquipementType.DEUX_FAUTEUILS_REALISATEUR),
                    new Equipement(EquipementType.FAUTEUIL_ET_UN_LIT)));
        }
    }
    private Client ajouterClients(){
         Client client = new Client();
         client.setNom("benga");
         client.setPrenom("jp");
         return clientDao.save(client);
    }

    private void ajouterConcessionnaire() {
        if (concessionnaireDao.count() == 0) {
            Faker faker = new Faker(Locale.FRENCH);
            Concessionnaire concessionnaire = new Concessionnaire();
            concessionnaire.setNom("ROSSI");
            concessionnaire.setPrenom("Giuseppe");
            concessionnaire.setEmail("peppe@humanbooster.fr");
            concessionnaire.setMotDePasse("12345678");
            concessionnaire.setNumeroDeTelephone(faker.phoneNumber().cellPhone());
            concessionnaireDao.save(concessionnaire);
        }
    }

    private void ajouterClients(int nbClientsAAjouter) {
        if (clientDao.count() == 0) {
            List<Pays> pays = paysDao.findAll();
            LienDeParente lienDeParenteAucun = lienDeParenteDao.findByNom("Aucun");
            Map<String, Client> map = new HashMap<>();
            Calendar calendar = Calendar.getInstance();
            Random random = new Random();
            Faker faker = new Faker(Locale.FRENCH);

            while (map.size() != nbClientsAAjouter) {
                Client client = Client.builder().nom(faker.name().lastName()).prenom(faker.name().firstName())
                        .pays(pays.get(random.nextInt(pays.size())))
                        .email(faker.internet().emailAddress())
                        .lienDeParente(lienDeParenteAucun)
                        .motDePasse(String.valueOf(random.nextInt(99999999) + 10000000)).build();
                calendar.set(2020, 1, 1);
                Date dateDebut = calendar.getTime();
                calendar = Calendar.getInstance();
                Date dateFin = calendar.getTime();
                Date dateAleatoire = faker.date().between(dateDebut, dateFin);
                calendar.setTime(dateAleatoire);
                LocalDateTime dateHeureInscription = dateAleatoire.toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                client.setDateHeureInscription(dateHeureInscription);
                map.put(client.getEmail(), client);
            }
            clientDao.saveAll(map.values());
        }
    }
    private void ajouterReservations(int nbReservationsAAjouter) {

        List<Client> clients = clientDao.findAll();
        List<Parasol> parasols = parasolDao.findAll();
        List<Equipement> equipements = equipementDao.findAll(); // Ajoutez cette ligne
        System.out.println(equipements);

        Random random = new Random();
        Statut statutEnAttente = statutDao.findByNom("en attente de traitement");

        LocalDate dateDebut = LocalDate.of(2020, random.nextInt(3) + 6, random.nextInt(30) + 1);
        LocalDate dateFin = dateDebut;
        for(int i = 0; i < nbReservationsAAjouter; i++){
            Reservation reservation = Reservation.builder()
                    .client(clients.get(random.nextInt(clients.size())))
                    .parasols(Arrays.asList(parasols.get(random.nextInt(parasols.size())))).dateDebut(dateDebut)
                    .equipement(equipements.get(random.nextInt(equipements.size()))) // Ajoutez cette ligne
                    .dateFin(dateFin).statut(statutEnAttente).build();
            reservationDao.save(reservation);
            i++;
        }
    }
    private void ajouterStatuts() {
        if (statutDao.count()==0) {
            statutDao.saveAll(Arrays.asList(new Statut("en attente de traitement"),
                    new Statut("acceptée"), new Statut("refusée")));
        }
    }
}

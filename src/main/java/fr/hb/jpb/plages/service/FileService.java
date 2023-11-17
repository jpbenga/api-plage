package fr.hb.jpb.plages.service;

import fr.hb.jpb.plages.dto.FileDto;

import java.util.List;

public interface FileService {

    FileDto ajouterFile(FileDto fileDto);

    List<FileDto> recupererFiles();

    FileDto recupererFile(Long id);

    FileDto mettreAJourFile(Long id, FileDto fileDto);

    boolean supprimerFile(Long id);

    // Ajoutez d'autres méthodes CRUD ici si nécessaire

}

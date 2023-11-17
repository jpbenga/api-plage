package fr.hb.jpb.plages.service.impl;

import fr.hb.jpb.plages.business.File;
import fr.hb.jpb.plages.dao.FileDao;
import fr.hb.jpb.plages.dto.FileDto;
import fr.hb.jpb.plages.mapper.FileMapper;
import fr.hb.jpb.plages.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {

    private final FileDao fileDao;
    private final FileMapper fileMapper;

    public FileServiceImpl(FileDao fileDao, FileMapper fileMapper) {
        this.fileDao = fileDao;
        this.fileMapper = fileMapper;
    }

    @Override
    public FileDto ajouterFile(FileDto fileDto) {
        File file = fileMapper.toEntity(fileDto);
        File savedFile = fileDao.save(file);
        return fileMapper.toDto(savedFile);
    }

    @Override
    public List<FileDto> recupererFiles() {
        List<File> files = fileDao.findAll();
        return files.stream()
                .map(fileMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FileDto recupererFile(Long id) {
        File file = fileDao.findById(id).orElse(null);
        return (file != null) ? fileMapper.toDto(file) : null;
    }

    @Override
    public FileDto mettreAJourFile(Long id, FileDto fileDto) {
        File existingFile = fileDao.findById(id).orElse(null);
        if (existingFile != null) {
            File updatedFile = fileMapper.toEntity(fileDto);
            updatedFile.setId(id);
            File savedFile = fileDao.save(updatedFile);
            return fileMapper.toDto(savedFile);
        }
        return null;
    }

    @Override
    public boolean supprimerFile(Long id) {
        File file = fileDao.findById(id).orElse(null);
        if (file != null) {
            fileDao.delete(file);
            return true;
        }
        return false;
    }

    // Ajoutez d'autres méthodes CRUD ici si nécessaire

}

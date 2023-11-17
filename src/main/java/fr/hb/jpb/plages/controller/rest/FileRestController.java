package fr.hb.jpb.plages.controller.rest;

import fr.hb.jpb.plages.dto.FileDto;
import fr.hb.jpb.plages.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/files")
@AllArgsConstructor
@Validated
public class FileRestController {

    private final FileService fileService;

    @Operation(description = "Ajoute une file")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public FileDto ajouterFile(@RequestBody FileDto fileDto) {
        return fileService.ajouterFile(fileDto);
    }

    @Operation(description = "Renvoie la liste de toutes les files")
    @GetMapping
    public List<FileDto> recupererFiles() {
        return fileService.recupererFiles();
    }

    @Operation(description = "Renvoie la file dont l'id est donné en paramètre")
    @GetMapping("/{id}")
    public FileDto recupererFile(@PathVariable Long id) {
        return fileService.recupererFile(id);
    }

    @Operation(description = "Met à jour complètement la file")
    @PutMapping("/{id}")
    public ResponseEntity<FileDto> mettreAJourFile(@PathVariable Long id, @RequestBody FileDto fileDto) {
        FileDto updatedFile = fileService.mettreAJourFile(id, fileDto);

        if (updatedFile != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedFile);
        } else {
            // Gérer le cas où l'id ne correspond à aucune file existante
            // Vous pouvez lancer une exception ou retourner un ResponseEntity avec un statut différent,
            // selon vos besoins.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(description = "Supprime la file dont l'id est donné en paramètre")
    @DeleteMapping("/{id}")
    public boolean supprimerFile(@PathVariable Long id) {
        return fileService.supprimerFile(id);
    }

    // Ajoutez d'autres opérations CRUD ici si nécessaire

}

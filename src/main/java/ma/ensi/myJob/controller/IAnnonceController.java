package ma.ensi.myJob.controller;

import ma.ensi.myJob.DTO.AnnonceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IAnnonceController {
    @PostMapping
    ResponseEntity<Void> ajouterAnnonce(AnnonceDTO dto, String email);



    @GetMapping
    ResponseEntity<AnnonceDTO> consulterAnnonce(Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> supprimerAnnonce(Long id);

    @GetMapping
    ResponseEntity<List<AnnonceDTO>> getAllAnnonces();

    @GetMapping
    ResponseEntity<List<AnnonceDTO>> getAnnoncesByRecruteurId(Long recruteurId);
}

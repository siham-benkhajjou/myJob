package ma.ensi.myJob.controller;

import ma.ensi.myJob.DTO.ReclamationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IReclamationController {

    @PostMapping
    ResponseEntity<Void> ajouterReclamation(@RequestBody ReclamationDTO dto,@RequestBody String email);

    @GetMapping
    ResponseEntity<List<ReclamationDTO>> getAllReclamations();

    @GetMapping("/{id}")
    ResponseEntity<ReclamationDTO> consulterReclamation(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> supprimerReclamation(@PathVariable Long id);

    @PutMapping
    ResponseEntity<Void> modifierReclamation(@RequestBody ReclamationDTO dto);

    @GetMapping("/by-recruteur/{recruteurId}")
    ResponseEntity<List<ReclamationDTO>> getReclamationsByRecruteurId(@PathVariable Long recruteurId);

}

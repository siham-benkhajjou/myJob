package ma.ensi.myJob.controller;

import ma.ensi.myJob.DTO.OffreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IOffreController {

    @PostMapping("/add")
    ResponseEntity<Void> addOffre(@RequestBody OffreDto dto, @RequestParam String email);

    @GetMapping("/all")
    ResponseEntity<List<OffreDto>> getAllOffres();

    @GetMapping("/{id}")
    ResponseEntity<OffreDto> consulterOffre(@PathVariable Long id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> supprimerOffre(@PathVariable Long id);

    @GetMapping("/recruteur/{recruteurId}")
    ResponseEntity<List<OffreDto>> getOffresByRecruteurId(@PathVariable Long recruteurId);
}

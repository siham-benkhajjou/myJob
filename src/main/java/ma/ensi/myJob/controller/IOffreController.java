package ma.ensi.myJob.controller;

import ma.ensi.myJob.DTO.OffreDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IOffreController {

    @PostMapping("/add")
    ResponseEntity<Void> createOffre(@RequestBody OffreDto dto, @RequestParam Long recruteurId);

    @GetMapping("/all")
    ResponseEntity<List<OffreDto>> getAllOffres();

    @GetMapping("/{id}")
    ResponseEntity<OffreDto> getOffreById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    ResponseEntity<OffreDto> updateOffre(@PathVariable Long id, @RequestBody OffreDto dto);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteOffre(@PathVariable Long id);

    @GetMapping("/recruteur/{recruteurId}")
    ResponseEntity<List<OffreDto>> getOffresByRecruteur(@PathVariable Long recruteurId);
}

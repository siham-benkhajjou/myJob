package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.OffreDto;
import ma.ensi.myJob.serviceImpl.OffreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offres")
public class OffreControllerImpl {

    @Autowired
    private OffreServiceImpl offreServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<OffreDto> addOffre(@RequestBody OffreDto dto, @RequestParam String email) {
        OffreDto created = offreServiceImpl.ajouterOffre(dto, email);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OffreDto>> getAllOffres() {
        return ResponseEntity.ok(offreServiceImpl.getAllOffres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffreDto> getOffre(@PathVariable Long id) {
        OffreDto offre = offreServiceImpl.consulterOffre(id);
        return offre != null ? ResponseEntity.ok(offre) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffre(@PathVariable Long id) {
        offreServiceImpl.supprimerOffre(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<OffreDto> updateOffre(@RequestBody OffreDto dto) {
        return ResponseEntity.ok(offreServiceImpl.modifierOffre(dto));
    }

    @GetMapping("/recruteur/{recruteurId}")
    public ResponseEntity<List<OffreDto>> getOffresByRecruteurId(@PathVariable Long recruteurId) {
        return ResponseEntity.ok(offreServiceImpl.getOffresByRecruteurId(recruteurId));
    }
}

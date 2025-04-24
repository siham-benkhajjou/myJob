package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.OffreDto;
import ma.ensi.myJob.controller.IOffreController;
import ma.ensi.myJob.serviceImpl.OffreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offres")
public class OffreControllerImp implements IOffreController {

    @Autowired
    private OffreServiceImpl offreService;

    // Create a new job offer
    @Override
    @PostMapping("/add")
    public ResponseEntity<Void> createOffre(@RequestBody OffreDto dto, @RequestParam Long recruteurId) {
        try {
            offreService.createOffre(dto, recruteurId);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    // Retrieve all job offers
    @Override
    @GetMapping("/all")
    public ResponseEntity<List<OffreDto>> getAllOffres() {
        List<OffreDto> offres = offreService.getAllOffresByRecruteur(1L); // Update 1L with dynamic recruteurId
        return ResponseEntity.ok(offres);
    }

    // Retrieve a specific job offer by ID
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OffreDto> getOffreById(@PathVariable Long id) {
        OffreDto offre = offreService.getOffreById(id);
        return ResponseEntity.ok(offre);
    }

    // Update an existing job offer
    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<OffreDto> updateOffre(@PathVariable Long id, @RequestBody OffreDto dto) {
        OffreDto updatedOffre = offreService.updateOffre(id, dto);
        return ResponseEntity.ok(updatedOffre);
    }

    // Delete a specific job offer
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOffre(@PathVariable Long id) {
        offreService.deleteOffre(id);
        return ResponseEntity.noContent().build();
    }

    // Retrieve all job offers posted by a specific recruiter
    @Override
    @GetMapping("/recruteur/{recruteurId}")
    public ResponseEntity<List<OffreDto>> getOffresByRecruteur(@PathVariable Long recruteurId) {
        List<OffreDto> offres = offreService.getAllOffresByRecruteur(recruteurId);
        return ResponseEntity.ok(offres);
    }
}

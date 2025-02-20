package ma.ensi.myJob.controller;

import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.service.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recruteurs")
public class RecruteurController {

    @Autowired
    private RecruteurService recruteurService;

    @PostMapping
    public ResponseEntity<Recruteur> createRecruteur(@RequestBody Recruteur recruteur) {
        Recruteur savedRecruteur = recruteurService.saveRecruteur(recruteur);
        return new ResponseEntity<>(savedRecruteur, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Recruteur>> getAllRecruteurs() {
        List<Recruteur> recruteurs = recruteurService.getAllRecruteurs();
        return new ResponseEntity<>(recruteurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recruteur> getRecruteurById(@PathVariable Long id) {
        Optional<Recruteur> recruteur = recruteurService.getRecruteurById(id);
        return recruteur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruteur(@PathVariable Long id) {
        recruteurService.deleteRecruteur(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

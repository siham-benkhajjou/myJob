package ma.ensi.myJob.controller;

import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.service.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recruteurs")
public class RecruteurController implements IRecruteurController{

    @Autowired
    private RecruteurService recruteurService;

    @Override
    public ResponseEntity<Recruteur> register(RecruteurDto dto) {
        Recruteur recruteur = recruteurService.registerRecruteur(dto);
        return ResponseEntity.ok(recruteur);
    }

    @Override
    public ResponseEntity<Recruteur> createRecruteur(Recruteur recruteur) {
        Recruteur savedRecruteur = recruteurService.saveRecruteur(recruteur);
        return new ResponseEntity<>(savedRecruteur, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Recruteur>> getAllRecruteurs() {
        List<Recruteur> recruteurs = recruteurService.getAllRecruteurs();
        return new ResponseEntity<>(recruteurs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Recruteur> getRecruteurById(Long id) {
        Optional<Recruteur> recruteur = recruteurService.getRecruteurById(id);
        return recruteur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public ResponseEntity<Void> deleteRecruteur(Long id) {
        recruteurService.deleteRecruteur(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Recruteur> updateRecruteur(Long id, RecruteurDto dto) {
        Recruteur updated = recruteurService.updateRecruteur(id, dto);
        return ResponseEntity.ok(updated);
    }
}

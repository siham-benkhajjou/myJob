package ma.ensi.myJob.controllerImpl;


import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.controller.IRecruteurController;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.serviceImpl.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recruteurs")
public class RecruteurController implements IRecruteurController {

    @Autowired
    private RecruteurService recruteurService;

    @Override
    public ResponseEntity<Recruteur> createRecruteur(Recruteur recruteur) {
        Recruteur savedRecruteur = recruteurService.saveRecruteur(recruteur);
        return new ResponseEntity<>(savedRecruteur, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<RecruteurDto>> getAllRecruteurs() {
        List<RecruteurDto> recruteurs = recruteurService.getAllRecruteurs();
        return new ResponseEntity<>(recruteurs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RecruteurDto> getRecruteurById(@PathVariable Long id) {
        Optional<RecruteurDto> dto = recruteurService.getRecruteurById(id);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Override
    public ResponseEntity<Void> deleteRecruteur(Long id) {
        recruteurService.deleteRecruteur(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<RecruteurDto> updateRecruteur(@PathVariable Long id, @RequestBody RecruteurDto dto) {
        RecruteurDto updated = recruteurService.updateRecruteur(id, dto,null);
        return ResponseEntity.ok(updated);
    }

}

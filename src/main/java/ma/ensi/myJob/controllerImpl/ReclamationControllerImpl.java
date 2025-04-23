package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.AnnonceDTO;
import ma.ensi.myJob.DTO.ReclamationDTO;
import ma.ensi.myJob.controller.IReclamationController;
import ma.ensi.myJob.serviceImpl.ReclamationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/reclamations")
public class ReclamationControllerImpl implements IReclamationController {

    @Autowired
    ReclamationServiceImpl reclamationService;


    @Override
    public ResponseEntity<Void> ajouterReclamation(ReclamationDTO dto, String email) {
        reclamationService.ajouterReclamation(dto,email);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Override
    public ResponseEntity<List<ReclamationDTO>> getAllReclamations() {
        List<ReclamationDTO> reclamations = reclamationService.getAllReclamations();
        return ResponseEntity.ok(reclamations);
    }

    @Override
    public ResponseEntity<ReclamationDTO> consulterReclamation(Long id) {
        ReclamationDTO reclamation = reclamationService.consulterReclamation(id);
        return reclamation != null ? ResponseEntity.ok(reclamation) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> supprimerReclamation(Long id) {
        reclamationService.supprimerReclamation(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> modifierReclamation(ReclamationDTO dto) {
        reclamationService.modifierReclamation(dto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ReclamationDTO>> getReclamationsByRecruteurId(Long recruteurId) {
        List<ReclamationDTO> reclamations = reclamationService.getReclamationsByRecruteurId(recruteurId);
        return ResponseEntity.ok(reclamations);
    }
}

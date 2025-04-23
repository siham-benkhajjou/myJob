package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.AnnonceDTO;
import ma.ensi.myJob.controller.IAnnonceController;
import ma.ensi.myJob.entity.Annonce;
import ma.ensi.myJob.serviceImpl.AnnonceServiceImpl;
import ma.ensi.myJob.serviceImpl.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/annonces")
public class AnnonceControllerImp implements IAnnonceController {
    @Autowired
    private AnnonceServiceImpl annonceService;

    @Override
    @PostMapping("/add")
    public ResponseEntity<Void> ajouterAnnonce(@RequestBody AnnonceDTO dto, @RequestParam String email) {
        try {
            annonceService.ajouterAnnonce(dto, email);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @Override
    @GetMapping("/all")
    public ResponseEntity<List<AnnonceDTO>> getAllAnnonces() {
        List<AnnonceDTO> annonces = annonceService.getAllAnnonces();
        return ResponseEntity.ok(annonces);
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AnnonceDTO> consulterAnnonce(@PathVariable Long id) {
        AnnonceDTO annonce = annonceService.consulterAnnonce(id);
        return annonce != null ? ResponseEntity.ok(annonce) : ResponseEntity.notFound().build();
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> supprimerAnnonce(@PathVariable Long id) {
        try {
            annonceService.supprimerAnnonce(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Override
    @GetMapping("/recruteur/{recruteurId}")
    public ResponseEntity<List<AnnonceDTO>> getAnnoncesByRecruteurId(@PathVariable Long recruteurId) {
        List<AnnonceDTO> annonces = annonceService.getAnnoncesByRecruteurId(recruteurId);
        return ResponseEntity.ok(annonces);
    }

    @GetMapping("/{id}/consulter")
    public String consulterAnnonce(@PathVariable Long id, Model model) {
        Annonce annonce = annonceService.getAnnonceById(id);
        model.addAttribute("annonce", annonce);
        return "consulter-annonce";
    }
}


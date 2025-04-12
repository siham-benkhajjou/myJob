package ma.ensi.myJob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recruteur")
public class RecruteurPageController {

    // Dashboard Home
    @GetMapping("/home")
    public String home() {
        return "recruteur-home"; // templates/recruteur-home.html
    }

    // Mon Compte
    @GetMapping("/mon-compte")
    public String monCompte() {
        return "moncompterec"; // templates/moncompterec.html
    }

    // Annonce Consultation
    @GetMapping("/annonces")
    public String annonces() {
        return "recruteur-annonces"; // templates/recruteur-annonces.html
    }

    // Applications Reçues
    @GetMapping("/applications")
    public String applications() {
        return "recruteur-applications"; // templates/recruteur-applications.html
    }

    // Soumettre une Réclamation
    @GetMapping("/reclamation")
    public String reclamation() {
        return "recruteur-reclamation"; // templates/recruteur-reclamation.html
    }
}

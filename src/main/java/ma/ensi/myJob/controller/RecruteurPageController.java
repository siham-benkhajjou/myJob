package ma.ensi.myJob.controller;

import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/recruteur")
public class RecruteurPageController {
    @Autowired
    ma.ensi.myJob.service.RecruteurService recruteurService;

    // Dashboard Home
    @GetMapping("/home")
    public String home() {
        return "recruteur-home"; // templates/recruteur-home.html
    }


    @GetMapping("/mon-compte")
    public String monCompte(Model model, Principal principal) {

        String email = principal.getName(); // Retrieves the email of the logged-in user
        Recruteur recruteur = recruteurService.findByEmail(email); // Retrieves the Recruteur entity from DB
        model.addAttribute("recruteur", recruteur); // Makes it accessible in the HTML via ${recruteur}
        return "moncompterec"; // Tells Spring to render templates/moncompterec.html
    }

    @GetMapping("/offres")
    public String offresPage() {
        return "recruteur-offres";
    }

    @GetMapping("/annonces")
    public String annoncesPage() {
        return "recruteur-annonces";
    }

    @GetMapping("/applications")
    public String applicationsPage() {
        return "recruteur-applications";
    }


}

package ma.ensi.myJob.controllerImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.serviceImpl.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class PageController {
    @Autowired
    private RecruteurService recruteurService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/recruteur/register")
    public String showRecruiterForm() {
        return "recruteur-register";
    }

    @PostMapping("/recruteur")
    public String saveRecruteur(@ModelAttribute Recruteur recruteur,
                                @RequestParam("logoFile") MultipartFile logoFile,
                                 HttpServletRequest request,
                                Model model) {

        if (recruteurService.emailExists(recruteur.getEmail())) {
            model.addAttribute("emailError", "Cet email est déjà utilisé.");
            return "recruteur-register";
        }

        if (recruteur.getDateDeNaissance() != null) {
            int age = Period.between(recruteur.getDateDeNaissance(), LocalDate.now()).getYears();
            if (age < 18) {
                model.addAttribute("ageError", "Vous devez avoir au moins 18 ans.");
                return "recruteur-register";
            }
        }

        Recruteur saved = recruteurService.saveRecruteur(recruteur);

        if (!logoFile.isEmpty()) {
            String logoPath = recruteurService.saveLogoFile(logoFile, saved.getId());
            saved.setLogoEntreprise(logoPath);
            recruteurService.saveRecruteur(saved);
        }

        try {
            String logoPath = recruteurService.saveLogoFile(logoFile, saved.getId());
            request.login(saved.getEmail(), recruteur.getMdp());
            saved.setLogoEntreprise(logoPath);
        } catch (ServletException e) {
            recruteurService.saveRecruteur(saved);
            e.printStackTrace();
            return "redirect:/login";
        }

    return "redirect:/recruteur/home";
    }
}

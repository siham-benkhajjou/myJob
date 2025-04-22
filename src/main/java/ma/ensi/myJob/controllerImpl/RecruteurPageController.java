package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.ReclamationDTO;
import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Reclamation;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.mapper.RecruteurMapper;
import ma.ensi.myJob.repository.RecruteurRepository;
import ma.ensi.myJob.serviceImpl.ReclamationServiceImpl;
import ma.ensi.myJob.serviceImpl.RecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/recruteur")
public class RecruteurPageController {
    @Autowired
    RecruteurService recruteurService;
    @Autowired
    RecruteurRepository recruteurRepository;
    @Autowired
    ReclamationServiceImpl reclamationService;

    @GetMapping("/home")
    public String home() {
        return "recruteur-home"; // templates/recruteur-home.html
    }


    @GetMapping("/mon-compte")
    public String monCompte(Model model, Principal principal) {

        String userName = principal.getName(); // Retrieves the email of the logged-in user
        Recruteur recruteur = recruteurService.findByUsername(userName); // Retrieves the Recruteur entity from DB
        model.addAttribute("recruteur", recruteur); // Makes it accessible in the HTML via ${recruteur}

        String logoPath = recruteurService.getLogoOrDefault(recruteur);
        model.addAttribute("logoPath", logoPath);

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

    @GetMapping("/Reclamation")
    public String reclamationPage(Model model, Principal principal) {
        String name = principal.getName();
        Recruteur recruteur = recruteurService.findByUsername(name);
        List<Reclamation> reclamations = recruteur.getReclamations();
        model.addAttribute("reclamations", reclamations);
        return "recruteur-reclamation";
    }

    @GetMapping("/Reclamation/new")
    public String showNewReclamationForm(Model model) {
        model.addAttribute("reclamation", new ReclamationDTO());
        return "new-reclamation";
    }

    @PostMapping("/addReclamation")
    public String addReclamation(@ModelAttribute ReclamationDTO reclamationDTO,
                                 Principal principal,
                                 RedirectAttributes redirectAttributes) {
        try {
            reclamationService.ajouterReclamation(reclamationDTO, principal.getName());
            redirectAttributes.addFlashAttribute("successMessage", "Réclamation ajoutée avec succès!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de l'ajout de la réclamation");
        }
        return "redirect:/recruteur/Reclamation";
    }

    @PostMapping("/deleteReclamation/{id}")
    public String deleteReclamation(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            reclamationService.supprimerReclamation(id);
            redirectAttributes.addFlashAttribute("successMessage", "Réclamation supprimée avec succès.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de la suppression.");
        }
        return "redirect:/recruteur/Reclamation";
    }

    @GetMapping("/Reclamation/{id}")
    public String voirDetailsReclamation(@PathVariable Long id, Model model) {
        ReclamationDTO reclamation = reclamationService.consulterReclamation(id);
        model.addAttribute("reclamation", reclamation);
        return "reclamation-details";
    }
    @GetMapping("/Reclamation/edit/{id}")
    public String editReclamationForm(@PathVariable Long id, Model model) {
        ReclamationDTO reclamation = reclamationService.consulterReclamation(id);
        if (reclamation == null) {
            return "redirect:/recruteur/Reclamation";
        }
        model.addAttribute("reclamation", reclamation);
        return "edit-reclamation";
    }

    @PostMapping("/updateReclamation")
    public String updateReclamation(@ModelAttribute ReclamationDTO reclamationDTO,
                                    RedirectAttributes redirectAttributes) {
        try {
            reclamationService.modifierReclamation(reclamationDTO);
            redirectAttributes.addFlashAttribute("successMessage", "Réclamation modifiée avec succès.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de la modification.");
        }
        return "redirect:/recruteur/Reclamation";
    }

    @GetMapping("/modifier-compte-rec")
    public String showUpdateForm(Model model, Principal principal) {
        String userName = principal.getName();
        Recruteur recruteur = recruteurService.findByUsername(userName);
        model.addAttribute("recruteurDto", RecruteurMapper.toDto(recruteur));
        return "modifier-compte-rec";
    }

    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute RecruteurDto recruteurDto,
                                @RequestParam(value = "logoFile", required = false) MultipartFile logoFile,
                                Principal principal,
                                RedirectAttributes redirectAttributes) {
        try {
            String userName = principal.getName();
            Recruteur currentRecruteur = recruteurService.findByUsername(userName);
            recruteurService.updateRecruteur(currentRecruteur.getId(), recruteurDto, logoFile);

            redirectAttributes.addFlashAttribute("successMessage", "Profil mis à jour avec succès!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de la mise à jour du profil");
        }
        return "redirect:/recruteur/mon-compte";
    }

}

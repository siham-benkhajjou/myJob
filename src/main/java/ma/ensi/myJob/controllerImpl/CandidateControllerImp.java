package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.ReclamationDTO;
import ma.ensi.myJob.controller.ICandidatePageController;
import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.entity.Reclamation;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.serviceImpl.CandidatService;
import ma.ensi.myJob.serviceImpl.ReclamationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/candidate")
public class CandidateControllerImp implements ICandidatePageController {

    @Autowired
    CandidatService candidatService;

    @Autowired
    ReclamationServiceImpl reclamationService;

    @Override
    public String home() {
        return "candidate-home";
    }

    @Override
    public String reclamationPage(Model model, Principal principal) {
        String name = principal.getName();
        Candidat candidat = candidatService.findByUsername(name);
        List<Reclamation> reclamations = candidat.getReclamations();
        model.addAttribute("reclamations", reclamations);
        return "candidate-reclamation";
    }

    @GetMapping("/Reclamation/new")
    public String showNewReclamationForm(Model model) {
        model.addAttribute("reclamation", new ReclamationDTO());
        return "cand-new-reclamation";
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
        return "redirect:/candidate/Reclamation";
    }
    @PostMapping("/deleteReclamation/{id}")
    public String deleteReclamation(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            reclamationService.supprimerReclamation(id);
            redirectAttributes.addFlashAttribute("successMessage", "Réclamation supprimée avec succès.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de la suppression.");
        }
        return "redirect:/candidate/Reclamation";
    }

    @GetMapping("/Reclamation/{id}")
    public String voirDetailsReclamation(@PathVariable Long id, Model model) {
        ReclamationDTO reclamation = reclamationService.consulterReclamation(id);
        model.addAttribute("reclamation", reclamation);
        return "cand-reclamation-details";
    }
    @GetMapping("/Reclamation/edit/{id}")
    public String editReclamationForm(@PathVariable Long id, Model model) {
        ReclamationDTO reclamation = reclamationService.consulterReclamation(id);
        if (reclamation == null) {
            return "redirect:/candidate/Reclamation";
        }
        model.addAttribute("reclamation", reclamation);
        return "cand-edit-reclamation";
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
        return "redirect:/candidate/Reclamation";
    }
}

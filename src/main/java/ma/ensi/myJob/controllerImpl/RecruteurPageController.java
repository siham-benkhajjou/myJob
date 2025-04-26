package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.*;
import ma.ensi.myJob.entity.*;
import ma.ensi.myJob.mapper.*;
import ma.ensi.myJob.repository.RecruteurRepository;
import ma.ensi.myJob.serviceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recruteur")
public class RecruteurPageController {
    @Autowired
    RecruteurService recruteurService;

    @Autowired
    ReclamationServiceImpl reclamationService;
    @Autowired
    private AnnonceServiceImpl annonceServiceImpl;
    @Autowired
    private RecruteurRepository recruteurRepository;

    @Autowired
    private OffreServiceImpl offreServiceImpl;

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
    @GetMapping("/annonces")
    public String annoncePage(Model model, Principal principal) {
        String name = principal.getName();
        Recruteur recruteur = recruteurService.findByUsername(name);
        List<AnnonceDTO> annonces = annonceServiceImpl.getAnnoncesByRecruteurId(recruteur.getId());
        model.addAttribute("annonces", annonces);
        return "annonce-list";
    }

    @GetMapping("/annonces/new")
    public String showNewAnnonceForm(Model model) {
        model.addAttribute("annonce", new AnnonceDTO());
        return "create-annonce";
    }

    @PostMapping("/addAnnonce")
    public String addAnnonce(@ModelAttribute AnnonceDTO annonceDTO,
                             Principal principal,
                             RedirectAttributes redirectAttributes) {
        try {
            annonceServiceImpl.ajouterAnnonce(annonceDTO, principal.getName());
            redirectAttributes.addFlashAttribute("successMessage", "Annonce ajoutée avec succès!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de l'ajout de l'annonce.");
        }
        return "redirect:/recruteur/annonces";
    }
    @GetMapping("/editAnnonce/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Annonce annonce = annonceServiceImpl.getAnnonceById(id); // Correct method
        model.addAttribute("annonce", annonce);
        return "modifier-annonce"; // your HTML file
    }

    @PostMapping("/updateAnnonce")
    public String updateAnnonce(@ModelAttribute Annonce annonce) {
        annonceServiceImpl.updateAnnonce(annonce);
        return "redirect:/recruteur/annonces";
    }

    @GetMapping("/annonces/{id}")
    public String consulterAnnonce(@PathVariable Long id, Model model) {
        Annonce annonce = annonceServiceImpl.getAnnonceById(id);
        model.addAttribute("annonce", annonce);
        return "consulter-annonce";
    }
    @GetMapping("/offres")
    public String offreList(Model model, Principal principal) {
        String name = principal.getName();
        Recruteur recruteur = recruteurService.findByUsername(name);
        List<OffreDto> offres = offreServiceImpl.getOffresByRecruteurId(recruteur.getId());
        String logoPath = recruteurService.getLogoOrDefault(recruteur);
        model.addAttribute("logoPath", logoPath);
        model.addAttribute("offres", offres);
        return "offre-list";
    }

    @GetMapping("/offres/new")
    public String showNewOffreForm(Model model) {
        model.addAttribute("offre", new OffreDto());
        return "offre-form";
    }



    @PostMapping("/addOffre")
    public String addOffre(@ModelAttribute("offre") OffreDto offreDto,
                           Principal principal,
                           RedirectAttributes redirectAttributes) {
        try {
            // Appeler le service pour sauvegarder l'offre et récupérer le DTO de l'offre
            OffreDto savedOffreDto = offreServiceImpl.ajouterOffre(offreDto, principal.getName());

            redirectAttributes.addFlashAttribute("successMessage", "Offre ajoutée avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de l'ajout de l'offre.");
        }

        return "redirect:/recruteur/offres";
    }
    // Page to load the form
    @GetMapping("/offres/edit/{id}")
    public String showModifierOffreForm(@PathVariable Long id, Model model) {
        OffreDto offre = offreServiceImpl.consulterOffre(id);
        model.addAttribute("offre", offre);
        return "modifier-offre";
    }

    // Form submission
    @PostMapping("/updateOffre")
    public String updateOffre(@ModelAttribute OffreDto offreDto,
                              Principal principal,
                              RedirectAttributes redirectAttributes) {
        try {
            offreDto = offreServiceImpl.modifierOffre(offreDto);
            redirectAttributes.addFlashAttribute("successMessage", "Offre modifiée avec succès !");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de la modification.");
        }
        return "redirect:/recruteur/offres";
    }

    @GetMapping("/offres/{id}")
    public String consulterOffre(@PathVariable Long id, Model model) {
        OffreDto offre = offreServiceImpl.consulterOffre(id);
        model.addAttribute("offre", offre);

        recruteurService.getRecruteurById(offre.getRecruteurId())
                .ifPresent(recruteur -> model.addAttribute("recruteur", recruteur));

        return "consulter-offre";
    }

    @PostMapping("/offres/delete/{id}")
    public String deleteOffre(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            offreServiceImpl.supprimerOffre(id);
            redirectAttributes.addFlashAttribute("successMessage", "Offre supprimée avec succès!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erreur lors de la suppression de l'offre.");
        }
        return "redirect:/recruteur/offres"; // Redirects back to the offers list
    }

}


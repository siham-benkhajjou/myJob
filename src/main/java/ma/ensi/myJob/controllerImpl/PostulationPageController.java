package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.serviceImpl.CandidatService;
import ma.ensi.myJob.serviceImpl.OffreServiceImpl;
import org.springframework.ui.Model;
import ma.ensi.myJob.DTO.OffreDto;
import ma.ensi.myJob.DTO.PostulationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class PostulationPageController {

    @Autowired
    private OffreServiceImpl offreService;

    @Autowired
    private CandidatService candidatService;

    @GetMapping("/candidate/postuler/{id}")
    public String showForm(@PathVariable("id") Long offreId, Model model, Principal principal) {
        OffreDto offre = offreService.consulterOffre(offreId);
        String name = principal.getName();
        Candidat candidat = candidatService.findByUsername(name);

        model.addAttribute("offre", offre);
        model.addAttribute("candidat", candidat);
        return "postulation-form"; // Ton fichier HTML doit être : src/main/resources/templates/postulation-form.html
    }



}


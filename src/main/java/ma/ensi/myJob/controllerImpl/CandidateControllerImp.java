package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.controller.ICandidatePageController;
import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.entity.Reclamation;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.serviceImpl.CandidatService;
import ma.ensi.myJob.serviceImpl.ReclamationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/candidate")
public class CandidateControllerImp implements ICandidatePageController {

    @Autowired
    CandidatService candidatService;

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
        return "recruteur-reclamation";
    }

}

package ma.ensi.myJob.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

public interface ICandidatePageController {
    @GetMapping("/home")
    public String home();

    @GetMapping("/Reclamation")
    public String reclamationPage(Model model, Principal principal);
}

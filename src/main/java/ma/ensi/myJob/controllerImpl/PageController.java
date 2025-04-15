package ma.ensi.myJob.controllerImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/recruiter")
    public String showRecruiterForm() {
        return "recruiter-register";
    }

    @GetMapping("/candidat")
    public String showCandidatForm() {
        return "candidat-register";
    }
}

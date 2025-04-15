package ma.ensi.myJob.controllerImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootRedirectController {

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }
}

package ma.ensi.myJob.controllerImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/candidate")
public class CandidateControllerImp {

    @GetMapping("/home")
    public String home() {
        return "candidate-home";
    }

}

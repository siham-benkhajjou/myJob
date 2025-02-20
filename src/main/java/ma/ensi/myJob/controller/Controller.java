package ma.ensi.myJob.controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }
}

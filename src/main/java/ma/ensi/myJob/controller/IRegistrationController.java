package ma.ensi.myJob.controller;

import jakarta.servlet.http.HttpServletRequest;
import ma.ensi.myJob.DTO.CandidatRegisterDto;
import ma.ensi.myJob.entity.Recruteur;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface IRegistrationController {

    @GetMapping("/login")
    public String showLoginPage();

    @GetMapping("/register")
    public String showRegisterPage();

    @GetMapping("/recruteur/register")
    public String showRecruiterForm();

    @PostMapping("/recruteur")
    public String saveRecruteur(@ModelAttribute Recruteur recruteur,
                                @RequestParam("logoFile") MultipartFile logoFile,
                                HttpServletRequest request,
                                Model model);

    @GetMapping("/candidate/register")
    public String showCandidateForm();

    @PostMapping("/candidate")
    public String saveCandidat(
            @ModelAttribute CandidatRegisterDto registerDto,
            @RequestParam("imageFile") MultipartFile imageFile,
            HttpServletRequest request,
            Model model);

    public boolean emailExistsInSystem(String email);
    public boolean UsernameExistsInSystem(String username);
}

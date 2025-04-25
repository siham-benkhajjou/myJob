package ma.ensi.myJob.controllerImpl;

import jakarta.servlet.http.HttpServletRequest;
import ma.ensi.myJob.DTO.CandidatRegisterDto;
import ma.ensi.myJob.controller.IRegistrationController;
import ma.ensi.myJob.entity.*;
import ma.ensi.myJob.mapper.CandidatMapper;
import ma.ensi.myJob.serviceImpl.CandidatService;
import ma.ensi.myJob.serviceImpl.ImageStorageServiceImpl;
import ma.ensi.myJob.serviceImpl.RecruteurService;
import ma.ensi.myJob.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class RegistrationControllerImpl implements IRegistrationController {
    @Autowired
    private RecruteurService recruteurService;

    @Autowired
    private CandidatService candidatService;

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    ImageStorageServiceImpl imageStorageService;

    @Override
    public String showLoginPage() {
        return "login";
    }

    @Override
    public String showRegisterPage() {
        return "register";
    }

    @Override
    public String showRecruiterForm() {
        return "recruteur-register";
    }

    @Override
    public String saveRecruteur(Recruteur recruteur,
                                MultipartFile logoFile,
                                 HttpServletRequest request,
                                Model model) {

        if (emailExistsInSystem(recruteur.getEmail())) {
            model.addAttribute("emailError", "Cet email est déjà utilisé.");
            return "recruteur-register";
        }

        if (recruteur.getDateDeNaissance() != null) {
            int age = Period.between(recruteur.getDateDeNaissance(), LocalDate.now()).getYears();
            if (age < 18) {
                model.addAttribute("ageError", "Vous devez avoir au moins 18 ans.");
                return "recruteur-register";
            }
        }



        if (!logoFile.isEmpty()) {
            String logoPath = imageStorageService.saveProfileImage(logoFile, recruteur.getUserName());
            recruteur.setLogoEntreprise(logoPath);
        }
        Recruteur saved = recruteurService.saveRecruteur(recruteur);

        try {
            authUtil.forceLogin(request, saved.getEmail(), saved.getMdp());
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login";
        }

    return "redirect:/recruteur/home";
    }

    @Override
    public String showCandidateForm() {
        return "candidate-register";
    }

    @Override
    public String saveCandidat(
            @ModelAttribute CandidatRegisterDto registerDto,
            @RequestParam("imageFile") MultipartFile imageFile,
            HttpServletRequest request,
            Model model) {

        if (emailExistsInSystem(registerDto.getEmail())) {
            model.addAttribute("emailError", "Cet email est déjà utilisé.");
            return "candidate-register";
        }
        if (UsernameExistsInSystem(registerDto.getUserName())) {
            model.addAttribute("userNameError", "Cet User name est déjà utilisé.");
            return "candidate-register";
        }

        if (registerDto.getDateDeNaissance() != null) {
            int age = Period.between(registerDto.getDateDeNaissance(), LocalDate.now()).getYears();
            if (age < 18) {
                model.addAttribute("ageError", "Vous devez avoir au moins 18 ans.");
                return "candidate-register";
            }
        }

        Candidat candidat = CandidatMapper.toEntity(registerDto);


        if (!imageFile.isEmpty()) {
            String imagePath = imageStorageService.saveProfileImage(imageFile, candidat.getUserName());
            candidat.setImage(imagePath);

        }
        Candidat saved = candidatService.saveCandidat(candidat);

        try {
            authUtil.forceLogin(request, saved.getEmail(), saved.getMdp());
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login";
        }

        return "redirect:/candidate/home";
    }

    @Override
    public boolean emailExistsInSystem(String email) {
        return recruteurService.emailExists(email) || candidatService.emailExists(email);
    }

    @Override
    public boolean UsernameExistsInSystem(String username) {
        return recruteurService.usernameExists(username);
    }

}

package ma.ensi.myJob.service;


import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IRecruteurService {

    List<RecruteurDto> getAllRecruteurs();
    Optional<RecruteurDto> getRecruteurById(Long id);
    Recruteur saveRecruteur(Recruteur recruteur);
    void deleteRecruteur(Long id);
    RecruteurDto updateRecruteur(Long id, RecruteurDto dto, MultipartFile logoFile);
    Recruteur findByEmail(String email);
    Recruteur findByUsername(String username);
    boolean emailExists(String email);
    boolean usernameExists(String userName);
    String saveLogoFile(MultipartFile file, Long id);
}
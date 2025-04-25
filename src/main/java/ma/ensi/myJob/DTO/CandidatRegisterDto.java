package ma.ensi.myJob.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
public class CandidatRegisterDto {
    private String nom;
    private String prenom;
    private String email;
    private String userName;
    private String mdp;
    private String cin;
    private String fonctionnement;
    private Integer numTele;
    private LocalDate dateDeNaissance;
    private MultipartFile imageFile;
    private List<DiplomeDto> diplomes;
    private List<LangueDto> langues;
    private List<CertificatDto> certificats;
    private List<ExperienceDto> experiences;
    private List<CompetenceDto> competences;

}

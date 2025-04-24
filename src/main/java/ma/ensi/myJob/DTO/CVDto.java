package ma.ensi.myJob.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CVDto {
    private String template;
    private List<ExperienceDto> experiences;
    private List<CompetenceDto> competences;
    private List<LangueDto> langues;
    private List<CertificatDto> certificats;
    private List<DiplomeDto> diplomes;
}
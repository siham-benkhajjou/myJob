package ma.ensi.myJob.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class ExperienceDto {
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private String description;
}

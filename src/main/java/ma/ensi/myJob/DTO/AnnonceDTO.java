package ma.ensi.myJob.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data

public class AnnonceDTO {

    private Long id;
    private String titre;
    private String description;
    private String localisation;
    private LocalDate datePublication;
    private Long recruteurId;

    public void setDate_Publication(Date datePublication) {

    }
}

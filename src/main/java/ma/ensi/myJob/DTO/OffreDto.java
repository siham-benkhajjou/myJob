package ma.ensi.myJob.DTO;

import lombok.Data;
import java.time.LocalDate;
import java.util.Date;

@Data
public class OffreDto {
    private Long id;
    private String intitule;
    private String type;
    private String description;
    private LocalDate dateExpiration;
    private String statut;
    private String lieu;
    private Long recruteurId; // Foreign key for Recruteur

    private LocalDate datePublication;

    public void setDatePublication(Date datePublication) {

    }


}

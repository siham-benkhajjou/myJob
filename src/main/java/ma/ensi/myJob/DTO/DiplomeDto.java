package ma.ensi.myJob.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class DiplomeDto {
    private String titre;
    private String institution;
    private Date dateDelivrance;
    private Boolean statut;
}

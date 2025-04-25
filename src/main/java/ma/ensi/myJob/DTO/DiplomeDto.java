package ma.ensi.myJob.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class DiplomeDto {
    private String titre;
    private String institution;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDelivrance;
    private Boolean statut;
}

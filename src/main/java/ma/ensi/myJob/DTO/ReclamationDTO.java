package ma.ensi.myJob.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class ReclamationDTO {
    private Long idReclamation;
    private String description;
    private String type;
    private Date dateReclamation;
}

package ma.ensi.myJob.DTO;

import lombok.Data;
import ma.ensi.myJob.entity.ReclamationStatus;
import ma.ensi.myJob.entity.ReclamationType;

import java.util.Date;

@Data
public class ReclamationDTO {
    private Long idReclamation;
    private String title;
    private String description;
    private ReclamationType type;
    private ReclamationStatus status;
    private Date dateReclamation;
    private Long recruteurId;
    private Long candidatId;

    public String getTypeDisplayName() {
        return type != null ? type.getDisplayName() : "";
    }

    public String getStatusDisplayName() {
        return status != null ? status.getDisplayName() : "";
    }
}

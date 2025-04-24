package ma.ensi.myJob.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class CertificatDto {
    private String titre;
    private String organisation;
    private Date dateDelivrance;
    private Boolean statut;
}

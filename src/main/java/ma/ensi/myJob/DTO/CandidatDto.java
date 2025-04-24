package ma.ensi.myJob.DTO;

import lombok.Data;

@Data
public class CandidatDto {

    private String cin;
    private String email;
    private String nom;
    private String prenom;
    private String userName;
    private String fonctionnement;
    private Integer numTele;
    private String image;
    private CVDto cv;
}

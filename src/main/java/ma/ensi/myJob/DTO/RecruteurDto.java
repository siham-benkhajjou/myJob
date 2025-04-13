package ma.ensi.myJob.DTO;

import lombok.Data;

@Data
public class RecruteurDto {

    private String nom;
    private String prenom;
    private String poste;
    private String email;
    private String linkedin;

    private String nomEntreprise;
    private String logoEntreprise;
    private String secteur;
    private String adresse;
    private String siteWeb;
    private String description;

}

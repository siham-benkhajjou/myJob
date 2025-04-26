package ma.ensi.myJob.DTO;

import lombok.Data;
import ma.ensi.myJob.entity.Recruteur;

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
    private Long recruteurId;

    private LocalDate datePublication;

    private String nomEntreprise;

    public void setDate_Publication(Date datePublication) {

    }

    public String getNomEntreprise(Recruteur recruteur) {
        return recruteur != null ? recruteur.getNomEntreprise() : "N/A";
    }


}




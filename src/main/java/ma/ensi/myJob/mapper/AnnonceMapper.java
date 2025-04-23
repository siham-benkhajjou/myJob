package ma.ensi.myJob.mapper;

import ma.ensi.myJob.DTO.AnnonceDTO;
import ma.ensi.myJob.entity.Annonce;
import ma.ensi.myJob.entity.Recruteur;

public class AnnonceMapper {

    public static AnnonceDTO toDTO(Annonce annonce) {
        if (annonce == null) return null;

        AnnonceDTO dto = new AnnonceDTO();
        dto.setId(annonce.getId());
        dto.setTitre(annonce.getTitre());
        dto.setDescription(annonce.getDescription());
        dto.setLocalisation(annonce.getLocalisation());
        dto.setDate_Publication(annonce.getDatePublication());
        dto.setRecruteurId(
                annonce.getRecruteur() != null ? annonce.getRecruteur().getId() : null
        );

        return dto;
    }
    public static Annonce toEntity(AnnonceDTO dto, Recruteur recruteur) {
        if (dto == null) return null;

        Annonce annonce = new Annonce();
        annonce.setId(dto.getId());
        annonce.setTitre(dto.getTitre());
        annonce.setDescription(dto.getDescription());
        annonce.setLocalisation(dto.getLocalisation());

        annonce.setRecruteur(recruteur);
        return annonce;
    }
}

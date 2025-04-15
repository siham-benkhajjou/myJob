package ma.ensi.myJob.mapper;

import ma.ensi.myJob.DTO.ReclamationDTO;
import ma.ensi.myJob.entity.Reclamation;
import ma.ensi.myJob.entity.Recruteur;

public class ReclamationMapper {

    public static ReclamationDTO toDTO(Reclamation reclamation) {
        ReclamationDTO dto = new ReclamationDTO();
        dto.setIdReclamation(reclamation.getIdReclamation());
        dto.setTitle(reclamation.getTitle());
        dto.setDescription(reclamation.getDescription());
        dto.setType(reclamation.getType());
        dto.setDateReclamation(reclamation.getDateReclamation());
        dto.setStatus(reclamation.getStatus());

        if (reclamation.getRecruteur() != null) {
            dto.setRecruteurId(reclamation.getRecruteur().getId());
        }
        return dto;
    }

    public static Reclamation toEntity(ReclamationDTO dto, Recruteur recruteur) {
        Reclamation reclamation = new Reclamation();
        reclamation.setIdReclamation(dto.getIdReclamation());
        reclamation.setTitle(dto.getTitle());
        reclamation.setDescription(dto.getDescription());
        reclamation.setType(dto.getType());
        reclamation.setStatus(dto.getStatus());
        reclamation.setDateReclamation(dto.getDateReclamation());
        reclamation.setRecruteur(recruteur);
        return reclamation;
    }
}

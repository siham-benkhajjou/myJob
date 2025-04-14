package ma.ensi.myJob.mapper;

import ma.ensi.myJob.DTO.ReclamationDTO;
import ma.ensi.myJob.entity.Reclamation;

public class ReclamationMapper {
    public static ReclamationDTO toDTO(Reclamation reclamation) {
        ReclamationDTO dto = new ReclamationDTO();
        dto.setIdReclamation(reclamation.getIdReclamation());
        dto.setDescription(reclamation.getDescription());
        dto.setType(reclamation.getType());
        dto.setDateReclamation(reclamation.getDateReclamation());
        return dto;
    }

    public static Reclamation toEntity(ReclamationDTO dto) {
        Reclamation reclamation = new Reclamation();
        reclamation.setIdReclamation(dto.getIdReclamation());
        reclamation.setDescription(dto.getDescription());
        reclamation.setType(dto.getType());
        reclamation.setDateReclamation(dto.getDateReclamation());
        return reclamation;
    }
}

package ma.ensi.myJob.mapper;

import ma.ensi.myJob.DTO.OffreDto;
import ma.ensi.myJob.entity.Offre;
import ma.ensi.myJob.entity.Recruteur;
import org.springframework.stereotype.Component;

@Component
public class OffreMapper {

    public OffreDto toDTO(Offre offre) {
        if (offre == null) return null;

        OffreDto dto = new OffreDto();
        dto.setId(offre.getId());
        dto.setIntitule(offre.getIntitule());
        dto.setType(offre.getType());
        dto.setDescription(offre.getDescription());
        dto.setDate_Publication(offre.getDatePublication());
        dto.setDateExpiration(offre.getDateExpiration());
        dto.setStatut(offre.getStatut());
        dto.setLieu(offre.getLieu());

        if (offre.getRecruteur() != null) {
            dto.setRecruteurId(offre.getRecruteur().getId());
            dto.setNomEntreprise(offre.getRecruteur().getNomEntreprise()); // ✅ Add this line
        }

        return dto;
    }

    public Offre toEntity(OffreDto dto, Recruteur recruteur) {
        if (dto == null) return null;

        Offre offre = new Offre();
        offre.setId(dto.getId());
        offre.setIntitule(dto.getIntitule());
        offre.setType(dto.getType());
        offre.setDescription(dto.getDescription());
        offre.setDateExpiration(dto.getDateExpiration());
        offre.setStatut(dto.getStatut());
        offre.setLieu(dto.getLieu());
        offre.setRecruteur(recruteur);
        return offre;
    }
}

package ma.ensi.myJob.mapper;

import ma.ensi.myJob.DTO.PostulationDTO;
import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.entity.Offre;
import ma.ensi.myJob.entity.Postulation;
import org.springframework.stereotype.Component;

@Component
public class PostulationMapper {
    public PostulationDTO toDto(Postulation postulation) {
        PostulationDTO dto = new PostulationDTO();
        dto.setId(postulation.getId());
        // On n'a plus besoin de setCandidatId ni setOffreId directement
        dto.setDatePostulation(postulation.getDatePostulation());
        return dto;
    }

    public Postulation toEntity(PostulationDTO dto, Candidat candidat, Offre offre) {
        Postulation postulation = new Postulation();
        postulation.setCandidat(candidat);    // L'objet complet du candidat
        postulation.setOffre(offre);           // L'objet complet de l'offre
        postulation.setDatePostulation(dto.getDatePostulation());
        return postulation;
    }
}

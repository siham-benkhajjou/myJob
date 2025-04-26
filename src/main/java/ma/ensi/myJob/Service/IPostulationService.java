package ma.ensi.myJob.Service;

import ma.ensi.myJob.DTO.PostulationDTO;

import java.util.List;

public interface IPostulationService {
    PostulationDTO postuler(PostulationDTO dto);

    List<PostulationDTO> getAllPostulations();

    PostulationDTO getPostulationById(Long id);

    void supprimerPostulation(Long id);
}

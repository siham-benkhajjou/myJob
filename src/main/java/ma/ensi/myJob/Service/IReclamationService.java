package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.ReclamationDTO;

import java.util.List;

public interface IReclamationService {

    void ajouterReclamation(ReclamationDTO dto);
    void modifierReclamation(ReclamationDTO dto);
    ReclamationDTO consulterReclamation(Long id);
    void supprimerReclamation(Long id);
    List<ReclamationDTO> getAllReclamations();
}

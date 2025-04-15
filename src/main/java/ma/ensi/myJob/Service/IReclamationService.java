package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.ReclamationDTO;

import java.util.List;

public interface IReclamationService {

    void ajouterReclamation(ReclamationDTO dto, String email);
    void modifierReclamation(ReclamationDTO dto);
    ReclamationDTO consulterReclamation(Long id);
    void supprimerReclamation(Long id);
    List<ReclamationDTO> getAllReclamations();
    List<ReclamationDTO> getReclamationsByRecruteurId(Long recruteurId);
}

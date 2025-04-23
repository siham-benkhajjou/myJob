package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.AnnonceDTO;

import java.util.List;

public interface IAnnonceService {
    List<AnnonceDTO> getAllAnnonces();
    List<AnnonceDTO> getAnnoncesByRecruteurId(Long recruteurId);
    void ajouterAnnonce(AnnonceDTO dto, String email);

     void modifierAnnonce(AnnonceDTO dto) ;
    AnnonceDTO consulterAnnonce(Long id);

    void supprimerAnnonce(Long id);
}

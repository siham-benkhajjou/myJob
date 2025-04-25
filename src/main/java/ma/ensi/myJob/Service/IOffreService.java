package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.OffreDto;
import ma.ensi.myJob.entity.Recruteur;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IOffreService {
    OffreDto ajouterOffre(OffreDto offreDto, String recruteurUsername);
    List<OffreDto> getAllOffres();
    OffreDto consulterOffre(Long id);
    void supprimerOffre(Long id);
    OffreDto modifierOffre(OffreDto dto);
    List<OffreDto> getOffresByRecruteurId(Long recruteurId);

}

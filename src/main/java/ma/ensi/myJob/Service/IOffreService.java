package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.OffreDto;
import java.util.List;

public interface IOffreService {
    OffreDto createOffre(OffreDto dto, Long recruteurId);
    List<OffreDto> getAllOffresByRecruteur(Long recruteurId);
    OffreDto getOffreById(Long id);
    OffreDto updateOffre(Long id, OffreDto dto);
    void deleteOffre(Long id);
}

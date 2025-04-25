package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.CandidatDto;
import ma.ensi.myJob.entity.Candidat;

import java.util.List;
import java.util.Optional;

public interface ICandidatService {
    List<CandidatDto> getAllCandidats();
    Optional<CandidatDto> getCandidatById(Long id);
    Candidat saveCandidat(Candidat candidat);
    void deleteCandidat(Long id);
    Candidat updateCandidat(Long id, CandidatDto dto);
    Candidat findByEmail(String email);
    Candidat findByUsername(String username);
    boolean emailExists(String email);
}

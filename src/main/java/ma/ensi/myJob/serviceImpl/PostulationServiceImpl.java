package ma.ensi.myJob.serviceImpl;

import ma.ensi.myJob.DTO.CandidatDto;
import ma.ensi.myJob.DTO.OffreDto;
import ma.ensi.myJob.DTO.PostulationDTO;


import ma.ensi.myJob.Service.IPostulationService;
import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.entity.Offre;
import ma.ensi.myJob.entity.Postulation;
import ma.ensi.myJob.mapper.PostulationMapper;
import ma.ensi.myJob.repository.CandidatRepository;
import ma.ensi.myJob.repository.OffreRepository;
import ma.ensi.myJob.repository.PostulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostulationServiceImpl implements IPostulationService {

    @Autowired private PostulationRepository postulationRepository;
    @Autowired private CandidatRepository candidatRepository;
    @Autowired private OffreRepository offreRepository;    // ou ton OffreService qui renvoie une entité

    private final PostulationMapper mapper = new PostulationMapper();

    @Override
    public PostulationDTO postuler(PostulationDTO dto) {
        // 1) Récupérer le Candidat
        Candidat candidat = candidatRepository.findById(dto.getCandidatId())
                .orElseThrow(() -> new RuntimeException(
                        "Candidat introuvable id=" + dto.getCandidatId()));

        // 2) Récupérer l'Offre (au lieu de la mapper manuellement)
        Offre offre = offreRepository.findById(dto.getOffreId())
                .orElseThrow(() -> new RuntimeException(
                        "Offre introuvable id=" + dto.getOffreId()));

        // 3) Créer la Postulation via le mapper
        Postulation postulation = mapper.toEntity(dto, candidat, offre);

        // 4) Sauvegarder et retourner le DTO
        Postulation saved = postulationRepository.save(postulation);
        return mapper.toDto(saved);
    }

    @Override
    public List<PostulationDTO> getAllPostulations() {
        return postulationRepository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostulationDTO getPostulationById(Long id) {
        Postulation postulation = postulationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postulation introuvable avec id : " + id));
        return mapper.toDto(postulation);
    }

    @Override
    public void supprimerPostulation(Long id) {
        if (!postulationRepository.existsById(id)) {
            throw new RuntimeException("La postulation avec id " + id + " n'existe pas !");
        }
        postulationRepository.deleteById(id);
    }
}

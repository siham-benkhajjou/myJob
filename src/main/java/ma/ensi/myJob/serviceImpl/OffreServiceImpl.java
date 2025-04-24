package ma.ensi.myJob.serviceImpl;

import ma.ensi.myJob.DTO.OffreDto;
import ma.ensi.myJob.entity.Offre;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.mapper.OffreMapper;
import ma.ensi.myJob.repository.OffreRepository;
import ma.ensi.myJob.repository.RecruteurRepository;
import ma.ensi.myJob.service.IOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OffreServiceImpl implements IOffreService {

    @Autowired
    private OffreMapper offreMapper;

    private final OffreRepository offreRepository;
    private final RecruteurRepository recruteurRepository;

    public OffreServiceImpl(OffreRepository offreRepository, RecruteurRepository recruteurRepository, OffreMapper offreMapper) {
        this.offreRepository = offreRepository;
        this.recruteurRepository = recruteurRepository;
        this.offreMapper = offreMapper;
    }

    @Override
    public OffreDto createOffre(OffreDto dto, Long recruteurId) {
        Recruteur recruteur = recruteurRepository.findById(recruteurId)
                .orElseThrow(() -> new RuntimeException("Recruteur not found"));

        Offre offre = offreMapper.toEntity(dto, recruteur);
        Offre saved = offreRepository.save(offre);
        return offreMapper.toDTO(offre);
    }

    public List<OffreDto> getAllOffresByRecruteur(Long recruteurId) {
        // Fetch offers by recruiter ID from the repository
        return offreRepository.findByRecruteurId(recruteurId).stream()
                .map(offreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OffreDto getOffreById(Long id) {
        Offre offre = offreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offre not found"));
        return offreMapper.toDTO(offre);
    }

    @Override
    public OffreDto updateOffre(Long id, OffreDto dto) {
        Offre existing = offreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offre not found"));

        existing.setIntitule(dto.getIntitule());
        existing.setType(dto.getType());
        existing.setDescription(dto.getDescription());
        existing.setDateExpiration(dto.getDateExpiration());
        existing.setStatut(dto.getStatut());
        existing.setLieu(dto.getLieu());

        Offre updated = offreRepository.save(existing);
        return offreMapper.toDTO(updated);
    }

    @Override
    public void deleteOffre(Long id) {
        offreRepository.deleteById(id);
    }
}

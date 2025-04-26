package ma.ensi.myJob.serviceImpl;

import lombok.RequiredArgsConstructor;
import ma.ensi.myJob.DTO.OffreDto;
import ma.ensi.myJob.entity.Offre;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.mapper.OffreMapper;
import ma.ensi.myJob.repository.OffreRepository;
import ma.ensi.myJob.repository.RecruteurRepository;
import ma.ensi.myJob.service.IOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class OffreServiceImpl implements IOffreService {

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private RecruteurRepository recruteurRepository;

    @Autowired
    private OffreMapper offreMapper;

    @Override
    public OffreDto ajouterOffre(OffreDto offreDto, String recruteurUsername) {
        Recruteur recruteur = recruteurRepository.findByUserName(recruteurUsername)
                .orElseThrow(() -> new RuntimeException("Recruteur not found with username: " + recruteurUsername));

        Offre offre = offreMapper.toEntity(offreDto, recruteur);
        Offre saved = offreRepository.save(offre);
        return offreMapper.toDTO(saved);
    }

    @Override
    public List<OffreDto> getAllOffres() {
        return offreRepository.findAll().stream()
                .map(offreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OffreDto consulterOffre(Long id) {
        Offre offre = offreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offre not found with ID: " + id));
        return offreMapper.toDTO(offre);
    }

    public void supprimerOffre(Long id) {
        Optional<Offre> offre = offreRepository.findById(id);
        if (offre.isPresent()) {
            offreRepository.deleteById(id);
        } else {
            throw new RuntimeException("Offre not found with id: " + id);
        }
    }

    @Override
    public OffreDto modifierOffre(OffreDto dto) {
        Offre existing = offreRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Offre not found with ID: " + dto.getId()));

        existing.setIntitule(dto.getIntitule());
        existing.setType(dto.getType());
        existing.setDescription(dto.getDescription());
        existing.setDateExpiration(dto.getDateExpiration());
        existing.setStatut(dto.getStatut());
        existing.setLieu(dto.getLieu());

        return offreMapper.toDTO(offreRepository.save(existing));
    }

    @Override
    public List<OffreDto> getOffresByRecruteurId(Long recruteurId) {
        return offreRepository.findByRecruteurId(recruteurId).stream()
                .map(offreMapper::toDTO)
                .collect(Collectors.toList());
    }
}

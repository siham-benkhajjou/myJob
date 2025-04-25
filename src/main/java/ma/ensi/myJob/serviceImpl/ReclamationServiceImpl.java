package ma.ensi.myJob.serviceImpl;

import ma.ensi.myJob.DTO.ReclamationDTO;
import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.entity.Reclamation;
import ma.ensi.myJob.entity.ReclamationStatus;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.mapper.ReclamationMapper;
import ma.ensi.myJob.repository.ReclamationRepository;
import ma.ensi.myJob.repository.RecruteurRepository;
import ma.ensi.myJob.service.IReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReclamationServiceImpl implements IReclamationService {

    @Autowired
    private ReclamationRepository repository;

    @Autowired
    private RecruteurService recruteurService;

    @Autowired
    private CandidatService candidatService;

    @Override
    public void ajouterReclamation(ReclamationDTO dto, String name) {
        Candidat candidat = candidatService.findByUsername(name);

        if (candidat != null) {
            dto.setCandidatId(candidat.getId());
            dto.setStatus(ReclamationStatus.NOUVELLE);
            Reclamation entity = ReclamationMapper.toEntity(dto, candidat);
            entity.setDateReclamation(new Date());
            repository.save(entity);
        }

            Recruteur recruteur = recruteurService.findByUsername(name);

            if (recruteur != null) {
                dto.setRecruteurId(recruteur.getId());
                dto.setStatus(ReclamationStatus.NOUVELLE);
                Reclamation entity = ReclamationMapper.toEntity(dto, recruteur);
                entity.setDateReclamation(new Date());
                repository.save(entity);
            }
            if(candidat == null && recruteur == null)
                throw new RuntimeException("User not found with username: " + name);

    }

    @Override
    public void modifierReclamation(ReclamationDTO dto) {
        Optional<Reclamation> optionalReclamation = repository.findById(dto.getIdReclamation());

        if (optionalReclamation.isPresent()) {
            Reclamation existing = optionalReclamation.get();
            existing.setTitle(dto.getTitle());
            existing.setDescription(dto.getDescription());
            existing.setType(dto.getType());

            repository.save(existing);
        } else {
            throw new RuntimeException("Reclamation not found with ID: " + dto.getIdReclamation());
        }
    }

    @Override
    public ReclamationDTO consulterReclamation(Long id) {
        Optional<Reclamation> rec = repository.findById(id);
        return rec.map(ReclamationMapper::toDTO).orElse(null);
    }

    @Override
    public void supprimerReclamation(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ReclamationDTO> getAllReclamations() {
        return repository.findAll().stream()
                .map(ReclamationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReclamationDTO> getReclamationsByRecruteurId(Long recruteurId) {
        if (!recruteurService.existsById(recruteurId)) {
            throw new RuntimeException("Recruteur not found with ID: " + recruteurId);
        }
        return repository.findByRecruteurId(recruteurId).stream()
                .map(ReclamationMapper::toDTO)
                .collect(Collectors.toList());
    }
}

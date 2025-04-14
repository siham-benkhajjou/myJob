package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.ReclamationDTO;
import ma.ensi.myJob.entity.Reclamation;
import ma.ensi.myJob.mapper.ReclamationMapper;
import ma.ensi.myJob.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReclamationServiceImpl implements IReclamationService {

    @Autowired
    private ReclamationRepository repository;

    @Override
    public void ajouterReclamation(ReclamationDTO dto) {
        repository.save(ReclamationMapper.toEntity(dto));
    }

    @Override
    public void modifierReclamation(ReclamationDTO dto) {
        Optional<Reclamation> optionalReclamation = repository.findById(dto.getIdReclamation());

        if (optionalReclamation.isPresent()) {
            Reclamation existing = optionalReclamation.get();

            existing.setDescription(dto.getDescription());
            existing.setType(dto.getType());
            existing.setDateReclamation(dto.getDateReclamation());

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
}

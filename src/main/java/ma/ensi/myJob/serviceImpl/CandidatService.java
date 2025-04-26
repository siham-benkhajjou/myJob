package ma.ensi.myJob.serviceImpl;

import ma.ensi.myJob.DTO.CandidatDto;
import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.mapper.CandidatMapper;
import ma.ensi.myJob.repository.CandidatRepository;
import ma.ensi.myJob.service.ICandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static ma.ensi.myJob.mapper.CandidatMapper.updateEntityFromDto;

@Service
public class CandidatService implements ICandidatService {

    @Autowired
    CandidatRepository repository;

    @Value("${app.upload-dir}")
    private String uploadDir;

    @Override
    public List<CandidatDto> getAllCandidats() {
        return repository.findAll().stream()
                .map(CandidatMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CandidatDto> getCandidatById(Long id) {
        return repository.findById(id)
                .map(CandidatMapper::toDto);
    }

    @Override
    public Candidat saveCandidat(Candidat candidat) {
        return repository.save(candidat);
    }


    @Override
    public Candidat updateCandidat(Long id, CandidatDto dto) {
        Candidat existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'id: " + id));

        updateEntityFromDto(dto, existing);

        return repository.save(existing);
    }

    @Override
    public Candidat findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public void deleteCandidat(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Candidat findByUsername(String username) {
        return repository.findByUserName(username).orElse(null);
    }

    @Override
    public boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }

    public String getLogoOrDefault(Candidat candidat) {
        String logoPath = candidat.getImage();
        if (logoPath != null && !logoPath.isEmpty()) {
            Path imagePath = Paths.get(uploadDir + "/src/main/resources/static" + logoPath);
            System.out.println(imagePath);
            if (Files.exists(imagePath)) {
                return logoPath;
            }
        }
        return "/assets/img/profile-img.jpg";
    }
}

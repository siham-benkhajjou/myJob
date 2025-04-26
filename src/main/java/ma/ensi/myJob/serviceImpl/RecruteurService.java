package ma.ensi.myJob.serviceImpl;

import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.mapper.RecruteurMapper;
import ma.ensi.myJob.repository.RecruteurRepository;
import ma.ensi.myJob.service.IRecruteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ma.ensi.myJob.mapper.RecruteurMapper.toDto;
import static ma.ensi.myJob.mapper.RecruteurMapper.updateEntityFromDto;

@Service
public class RecruteurService implements IRecruteurService {

    @Autowired
    private RecruteurRepository recruteurRepository;


    @Value("${app.upload-dir}")
    private String uploadDir;

    @Override
    public List<RecruteurDto> getAllRecruteurs() {
        return recruteurRepository.findAll().stream()
                .map(RecruteurMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RecruteurDto> getRecruteurById(Long id) {
        return recruteurRepository.findById(id)
                .map(RecruteurMapper::toDto);
    }

    @Override
    public Recruteur saveRecruteur(Recruteur recruteur) {
        return recruteurRepository.save(recruteur);
    }

    @Override
    public void deleteRecruteur(Long id) {
        recruteurRepository.deleteById(id);
    }

    @Override
    public RecruteurDto updateRecruteur(Long id, RecruteurDto dto, MultipartFile logoFile) {
        Recruteur existingRecruteur = recruteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruteur non trouvé avec l'id: " + id));

        updateEntityFromDto(dto, existingRecruteur);

        if (logoFile != null && !logoFile.isEmpty()) {
            String logoPath = saveLogoFile(logoFile, id);
            existingRecruteur.setLogoEntreprise(logoPath);
        }

        return toDto(recruteurRepository.save(existingRecruteur));
    }


    @Override
    public Recruteur findByEmail(String email) {
        return recruteurRepository.findByEmail(email);
    }

    @Override
    public Recruteur findByUsername(String username) {
        return recruteurRepository.findByUserName(username).orElse(null);
    }

    @Override
    public boolean emailExists(String email) {
        return recruteurRepository.findByEmail(email) != null;
    }

    @Override
    public boolean usernameExists(String userName) {
        return recruteurRepository.findByuserName(userName) != null;
    }

    @Override
    public String saveLogoFile(MultipartFile file, Long id) {
        try {
            String fileName = "profile.png";
            Path uploadPath = Paths.get(uploadDir + "/src/main/resources/static/assets/img/" + id);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());

            return "/assets/img/" + id + "/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de l'enregistrement du logo", e);
        }
    }

    public String getLogoOrDefault(Recruteur recruteur) {
        String logoPath = recruteur.getLogoEntreprise();
        if (logoPath != null && !logoPath.isEmpty()) {
            Path imagePath = Paths.get(uploadDir + "/src/main/resources/static" + logoPath);
            if (Files.exists(imagePath)) {
                return logoPath;
            }
        }
        return "/assets/img/profile-img.jpg";
    }

    public boolean existsById(Long id){
        return recruteurRepository.existsById(id);
    }

    public Recruteur findById(Long id) {
        return recruteurRepository.findById(id).orElse(null);
    }
}


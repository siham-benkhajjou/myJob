package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.mapper.RecruteurMapper;
import ma.ensi.myJob.repository.RecruteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static ma.ensi.myJob.mapper.RecruteurMapper.toDto;
import static ma.ensi.myJob.mapper.RecruteurMapper.updateEntityFromDto;

@Service
public class RecruteurService implements IRecruteurService{

    @Autowired
    private RecruteurRepository recruteurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<RecruteurDto> getAllRecruteurs() {
        Iterable<Recruteur> recruteurs = recruteurRepository.findAll();
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
        recruteur.setMdp(passwordEncoder.encode(recruteur.getMdp()));
        return recruteurRepository.save(recruteur);
    }
    @Override
    public void deleteRecruteur(Long id) {
        recruteurRepository.deleteById(id);
    }
    @Override
    public RecruteurDto updateRecruteur(Long id, RecruteurDto dto){
        Optional<Recruteur> optionalRecruteur = recruteurRepository.findById(id);

        if (optionalRecruteur.isEmpty()) {
            throw new RuntimeException("Recruteur non trouvé avec l'id: " + id);
        }
        Recruteur existingRecruteur = optionalRecruteur.get();
        updateEntityFromDto(dto, existingRecruteur);
        Recruteur updated = recruteurRepository.save(existingRecruteur);
        return toDto(updated);
  }
}

package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.repository.RecruteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruteurService implements IRecruteurService{

    @Autowired
    private RecruteurRepository recruteurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Recruteur registerRecruteur(RecruteurDto dto) {
        if (recruteurRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email deja utilise!");
        }
        Recruteur recruteur = new Recruteur();
        recruteur.setCin(dto.getCin());
        recruteur.setEmail(dto.getEmail());
        recruteur.setNom(dto.getNom());
        recruteur.setPrenom(dto.getPrenom());
        recruteur.setUserName(dto.getUserName());
        recruteur.setMdp(passwordEncoder.encode(dto.getMdp()));
        recruteur.setFonctionnement(dto.getFonctionnement());
        recruteur.setLinkedin(dto.getLinkedin());
        recruteur.setNomEntreprise(dto.getNomEntreprise());
        recruteur.setNumTele(dto.getNumTele());
        return saveRecruteur(recruteur);
    }

    @Override
    public List<Recruteur> getAllRecruteurs() {
        return (List<Recruteur>) recruteurRepository.findAll();
    }

    @Override
    public Optional<Recruteur> getRecruteurById(Long id) {
        return recruteurRepository.findById(id);
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
    public Recruteur updateRecruteur(Long id, RecruteurDto dto){
        Optional<Recruteur> optionalRecruteur = recruteurRepository.findById(id);

        if (optionalRecruteur.isEmpty()) {
            throw new RuntimeException("Recruteur non trouvé avec l'id: " + id);
        }
        Recruteur existingRecruteur = optionalRecruteur.get();

        existingRecruteur.setCin(dto.getCin());
        existingRecruteur.setEmail(dto.getEmail());
        existingRecruteur.setNom(dto.getNom());
        existingRecruteur.setPrenom(dto.getPrenom());
        existingRecruteur.setUserName(dto.getUserName());

        if (dto.getMdp() != null && !dto.getMdp().isEmpty()) {
            existingRecruteur.setMdp(passwordEncoder.encode(dto.getMdp()));
        }

        existingRecruteur.setFonctionnement(dto.getFonctionnement());
        existingRecruteur.setLinkedin(dto.getLinkedin());
        existingRecruteur.setNomEntreprise(dto.getNomEntreprise());
        existingRecruteur.setNumTele(dto.getNumTele());

        return recruteurRepository.save(existingRecruteur);
  }
}

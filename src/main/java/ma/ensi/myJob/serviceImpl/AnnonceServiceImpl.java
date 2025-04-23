package ma.ensi.myJob.serviceImpl;

import ma.ensi.myJob.DTO.AnnonceDTO;
import ma.ensi.myJob.entity.Annonce;
import ma.ensi.myJob.mapper.*;
import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.repository.AnnonceRepository;
import ma.ensi.myJob.repository.RecruteurRepository;
import ma.ensi.myJob.service.IAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AnnonceServiceImpl implements IAnnonceService{

    @Autowired
    private AnnonceRepository annonceRepository;
    private final AnnonceRepository annonceRepo;
    private final RecruteurRepository recruteurRepo;

    public AnnonceServiceImpl(AnnonceRepository annonceRepo, RecruteurRepository recruteurRepo, AnnonceRepository annonceRepository) {
        this.annonceRepo = annonceRepo;
        this.recruteurRepo = recruteurRepo;
        this.annonceRepository = annonceRepository;
    }

    @Override
    public void ajouterAnnonce(AnnonceDTO dto, String name) {
        Recruteur recruteur = recruteurRepo.findByUserName(name).get();
        Annonce annonce = AnnonceMapper.toEntity(dto, recruteur);
        annonceRepo.save(annonce);
    }


    @Override
    public AnnonceDTO consulterAnnonce(Long id) {
        Annonce annonce = annonceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Annonce not found"));

        return AnnonceMapper.toDTO(annonce);
    }

    @Override
    public void supprimerAnnonce(Long id) {
        annonceRepo.deleteById(id);
    }

    @Override
    public List<AnnonceDTO> getAllAnnonces() {
        return annonceRepo.findAll().stream()
                .map(AnnonceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnnonceDTO> getAnnoncesByRecruteurId(Long recruteurId) {
        return annonceRepo.findByRecruteurId(recruteurId).stream()
                .map(AnnonceMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void modifierAnnonce(AnnonceDTO dto) {
        Annonce existing = annonceRepository.findById(dto.getId()).orElseThrow();
        existing.setTitre(dto.getTitre());
        existing.setDescription(dto.getDescription());
        existing.setLocalisation(dto.getLocalisation());
        annonceRepository.save(existing);
    }

    public Annonce getAnnonceById(Long id) {
        return annonceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Annonce not found"));
    }

    public void updateAnnonce(Annonce updated) {
        Annonce original = annonceRepository.findById(updated.getId()).orElseThrow(() -> new RuntimeException("Annonce not found"));

        original.setTitre(updated.getTitre());
        original.setDescription(updated.getDescription());
        original.setLocalisation(updated.getLocalisation());
        annonceRepository.save(original);
    }

}


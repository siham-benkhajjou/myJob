package ma.ensi.myJob.service;

import ma.ensi.myJob.entity.Recruteur;
import ma.ensi.myJob.repository.RecruteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruteurService {
    @Autowired
    private RecruteurRepository recruteurRepository;

    public List<Recruteur> getAllRecruteurs() {
        return (List<Recruteur>) recruteurRepository.findAll();
    }

    public Optional<Recruteur> getRecruteurById(Long id) {
        return recruteurRepository.findById(id);
    }

    public Recruteur saveRecruteur(Recruteur recruteur) {
        return recruteurRepository.save(recruteur);
    }

    public void deleteRecruteur(Long id) {
        recruteurRepository.deleteById(id);
    }
}

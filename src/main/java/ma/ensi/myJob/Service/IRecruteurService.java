package ma.ensi.myJob.service;


import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;
import java.util.List;
import java.util.Optional;

public interface IRecruteurService {

    public List<Recruteur> getAllRecruteurs();

    public Optional<Recruteur> getRecruteurById(Long id);

    public Recruteur saveRecruteur(Recruteur recruteur);

    public void deleteRecruteur(Long id) ;

    public Recruteur updateRecruteur(Long id, RecruteurDto dto);

}
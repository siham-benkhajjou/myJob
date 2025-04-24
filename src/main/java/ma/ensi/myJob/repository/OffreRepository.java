package ma.ensi.myJob.repository;

import ma.ensi.myJob.entity.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Long> {
    List<Offre> findByRecruteurId(Long recruteurId);}

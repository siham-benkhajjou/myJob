package ma.ensi.myJob.repository;

import ma.ensi.myJob.entity.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
    List<Reclamation> findByRecruteurId(Long recruteurId);
}

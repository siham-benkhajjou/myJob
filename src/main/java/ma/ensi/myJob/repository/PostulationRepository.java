package ma.ensi.myJob.repository;

import ma.ensi.myJob.entity.Candidat;
import ma.ensi.myJob.entity.Offre;
import ma.ensi.myJob.entity.Postulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulationRepository extends JpaRepository<Postulation, Long> {
    boolean existsByCandidatAndOffre(Candidat candidat, Offre offre);
}

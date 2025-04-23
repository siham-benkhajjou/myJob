package ma.ensi.myJob.repository;

import ma.ensi.myJob.entity.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    List<Annonce> findByRecruteurId(Long recruteurId);
}

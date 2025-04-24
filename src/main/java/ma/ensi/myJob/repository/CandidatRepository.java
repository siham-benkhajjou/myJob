package ma.ensi.myJob.repository;

import ma.ensi.myJob.entity.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    Optional<Candidat> findByUserName(String userName);
    Candidat findByEmail(String email);
}

package ma.ensi.myJob.repository;

import ma.ensi.myJob.entity.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Long> {
    Recruteur findByNomEntreprise(String nomEntreprise);

    @Query("SELECT r FROM Recruteur r WHERE LOWER(r.email) = LOWER(:email)")
    Recruteur findByEmail(String email);

    @Query("SELECT r FROM Recruteur r WHERE LOWER(r.userName) = LOWER(:userName)")
    Recruteur findByuserName(String userName);

    Optional<Recruteur> findByUserName(String username);
}

package ma.ensi.myJob.repository;

import ma.ensi.myJob.entity.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Long> {

    @Query("SELECT r FROM Recruteur r WHERE LOWER(r.email) = LOWER(:email)")
    Recruteur findByEmail(String email);

    Optional<Recruteur> findByUserName(String username);
}

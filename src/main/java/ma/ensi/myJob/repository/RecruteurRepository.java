package ma.ensi.myJob.repository;

import ma.ensi.myJob.entity.Recruteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruteurRepository extends CrudRepository<Recruteur, Long> {
}

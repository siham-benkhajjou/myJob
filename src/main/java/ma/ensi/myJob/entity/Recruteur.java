package ma.ensi.myJob.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Recruteur extends Personne {

    @JsonProperty("fonctionnement")
    private String fonctionnement;

    @JsonProperty("linkedin")
    private String linkedin;

    @JsonProperty("nom_entreprise")
    private String nomEntreprise;

    @PrePersist
    public void setDefaultRole() {
        this.setRole(Role.RECRUTEUR);
    }

}

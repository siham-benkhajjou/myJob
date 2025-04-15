package ma.ensi.myJob.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Candidat extends Personne{

    @JsonProperty("image")
    private String image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    @JsonProperty("cv")
    private CV cv;

    @PrePersist
    public void setDefaultRole() {
        this.setRole(Role.CANDIDAT);
    }
}

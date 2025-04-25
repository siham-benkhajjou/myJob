package ma.ensi.myJob.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Candidat extends Personne{

    @JsonProperty("image")
    private String image;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "id")
    private CV cv;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("reclamations")
    private List<Reclamation> reclamations = new ArrayList<>();

    @PrePersist
    public void setDefaultRole() {
        this.setRole(Role.CANDIDAT);
    }
}

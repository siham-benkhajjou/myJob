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
public class Recruteur extends Personne {

    @JsonProperty("poste")
    private String poste;

    @JsonProperty("linkedin")
    private String linkedin;

    @JsonProperty("nom_entreprise")
    private String nomEntreprise;

    @JsonProperty("logo_entreprise")
    private String logoEntreprise;

    @JsonProperty("secteur")
    private String secteur;

    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("site_web")
    private String siteWeb;

    @JsonProperty("description")
    @Column(length = 2000)
    private String description;

    public String getFullName() {
        return getPrenom() + " " + getNom();
    }

    @PrePersist
    public void setDefaultRole() {
        this.setRole(Role.RECRUTEUR);
    }

    @OneToMany(mappedBy = "recruteur", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonProperty("reclamations")
    private List<Reclamation> reclamations = new ArrayList<>();

}

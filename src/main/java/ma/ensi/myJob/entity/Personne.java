package ma.ensi.myJob.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("cin")
    private String cin;

    @JsonProperty("email")
    private String email;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @Enumerated(EnumType.STRING)
    @JsonProperty("role")
    private Role role;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("mdp")
    private String mdp;

    @JsonProperty("fonctionnement")
    private String fonctionnement;

    @JsonProperty("num_tele")
    private Integer numTele;

    @JsonProperty("date_de_naissance")
    private LocalDate dateDeNaissance;

}

package ma.ensi.myJob.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
public class Offre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("intitule")
    private String intitule;

    @JsonProperty("type")
    private String type; // "Stage" or "Travail"

    @JsonProperty("description")
    private String description;

    @JsonProperty("dateExpiration")
    private LocalDate dateExpiration;

    @JsonProperty("statut")
    private String statut;

    @JsonProperty("lieu")
    private String lieu;

    @Temporal(TemporalType.DATE)
    @JsonProperty("date_Publication")
    private Date datePublication = new Date();

    @ManyToOne
    @JoinColumn(name = "id_recruteur")
    @JsonProperty("recruteur")
    private Recruteur recruteur;
}
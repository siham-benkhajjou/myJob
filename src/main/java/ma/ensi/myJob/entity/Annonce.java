package ma.ensi.myJob.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("titre")
    private String titre;

    @JsonProperty("description")
    private String description;

    @JsonProperty("localisation")
    private String localisation;

    @Temporal(TemporalType.DATE)
    @JsonProperty("date_Publication")
    private Date datePublication = new Date();

    @ManyToOne
    @JoinColumn(name = "id_recruteur")
    @JsonProperty("recruteur")
    private Recruteur recruteur;
}


package ma.ensi.myJob.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reclamation {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long idReclamation;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @Enumerated(EnumType.STRING)
    @JsonProperty("type")
    private ReclamationType type;

    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    private ReclamationStatus status = ReclamationStatus.NOUVELLE;

    @Temporal(TemporalType.DATE)
    @JsonProperty("date_reclamation")
    private Date dateReclamation = new Date();

    @ManyToOne
    @JoinColumn(name = "recruteur_id")
    @JsonProperty("recruteur")
    private Recruteur recruteur;
}
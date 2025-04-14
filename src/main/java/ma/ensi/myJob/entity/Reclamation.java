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

    @JsonProperty("description")
    private String description;

    @JsonProperty("type")
    private String type;

    @Temporal(TemporalType.DATE)
    @JsonProperty("date_reclamation")
    private Date dateReclamation;
}
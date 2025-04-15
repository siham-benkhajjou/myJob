package ma.ensi.myJob.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperience;

    private String type;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private String description;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;
}

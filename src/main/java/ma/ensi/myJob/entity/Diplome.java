package ma.ensi.myJob.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Diplome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiplome;

    private String titre;
    private String institution;

    @Temporal(TemporalType.DATE)
    private Date dateDelivrance;

    private Boolean statut;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;
}

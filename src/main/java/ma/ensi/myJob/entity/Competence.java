package ma.ensi.myJob.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompetence;

    private String nom;
    private String description;
    private int pourcentage;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;
}

package ma.ensi.myJob.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLangue;

    private String nom;
    private String niveau;
    private Boolean isMaitrise;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;
}

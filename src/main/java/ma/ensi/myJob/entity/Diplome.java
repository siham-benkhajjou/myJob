package ma.ensi.myJob.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDelivrance;

    private Boolean statut = false;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;
}

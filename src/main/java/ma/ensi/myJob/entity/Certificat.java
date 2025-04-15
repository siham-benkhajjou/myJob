package ma.ensi.myJob.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Certificat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCertificat;

    private String titre;
    private String organisation;

    @Temporal(TemporalType.DATE)
    private Date dateDelivrance;

    private Boolean statut;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;
}

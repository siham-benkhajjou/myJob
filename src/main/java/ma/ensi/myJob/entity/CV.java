package ma.ensi.myJob.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String template;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Experience> experiences = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Competence> competences = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Langue> langues = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Certificat> certificats = new ArrayList<>();

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Diplome> diplomes = new ArrayList<>();
}

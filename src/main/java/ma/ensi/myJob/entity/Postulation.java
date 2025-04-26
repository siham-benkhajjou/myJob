package ma.ensi.myJob.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;   // 🔥 L'utilisateur qui postule

    @ManyToOne
    @JoinColumn(name = "offre_id", nullable = false)
    private Offre offre;         // 🔥 L'offre à laquelle il postule

    private LocalDate datePostulation;

    @Column(length = 1000)
    private String lettreMotivation; // Optionnel : un texte libre du candidat

    // --- Getters et Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public LocalDate getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(LocalDate datePostulation) {
        this.datePostulation = datePostulation;
    }

    public String getLettreMotivation() {
        return lettreMotivation;
    }

    public void setLettreMotivation(String lettreMotivation) {
        this.lettreMotivation = lettreMotivation;
    }
}

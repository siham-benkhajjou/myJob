package ma.ensi.myJob.mapper;

import ma.ensi.myJob.DTO.*;
import ma.ensi.myJob.entity.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CVMapper {
    public static CVDto toDto(CV cv) {
        if (cv == null) return null;

        CVDto dto = new CVDto();
       // dto.setTemplate(cv.getTemplate());
        dto.setExperiences(cv.getExperiences().stream().map(CVMapper::toDto).collect(Collectors.toList()));
        dto.setCompetences(cv.getCompetences().stream().map(CVMapper::toDto).collect(Collectors.toList()));
        dto.setLangues(cv.getLangues().stream().map(CVMapper::toDto).collect(Collectors.toList()));
        dto.setCertificats(cv.getCertificats().stream().map(CVMapper::toDto).collect(Collectors.toList()));
        dto.setDiplomes(cv.getDiplomes().stream().map(CVMapper::toDto).collect(Collectors.toList()));
        return dto;
    }

    public static ExperienceDto toDto(Experience exp) {
        ExperienceDto dto = new ExperienceDto();
        dto.setType(exp.getType());
        dto.setDateDebut(exp.getDateDebut());
        dto.setDateFin(exp.getDateFin());
        dto.setDescription(exp.getDescription());
        return dto;
    }

    public static CompetenceDto toDto(Competence c) {
        CompetenceDto dto = new CompetenceDto();
        dto.setNom(c.getNom());
        dto.setDescription(c.getDescription());
        dto.setPourcentage(c.getPourcentage());
        return dto;
    }

    public static LangueDto toDto(Langue l) {
        LangueDto dto = new LangueDto();
        dto.setNom(l.getNom());
        dto.setNiveau(l.getNiveau());
        dto.setIsMaitrise(l.getIsMaitrise());
        return dto;
    }

    public static CertificatDto toDto(Certificat cert) {
        CertificatDto dto = new CertificatDto();
        dto.setTitre(cert.getTitre());
        dto.setOrganisation(cert.getOrganisation());
        dto.setDateDelivrance(cert.getDateDelivrance());
        dto.setStatut(cert.getStatut());
        return dto;
    }

    public static DiplomeDto toDto(Diplome d) {
        DiplomeDto dto = new DiplomeDto();
        dto.setTitre(d.getTitre());
        dto.setInstitution(d.getInstitution());
        dto.setDateDelivrance(d.getDateDelivrance());
        dto.setStatut(d.getStatut());
        return dto;
    }

    public static CV toEntity(CVDto dto) {
        if (dto == null) return null;

        CV cv = new CV();
        //cv.setTemplate(dto.getTemplate());

        cv.setExperiences(dto.getExperiences() != null ?
                dto.getExperiences().stream().map(CVMapper::toEntity).collect(Collectors.toList()) : new ArrayList<>());

        cv.setCompetences(dto.getCompetences() != null ?
                dto.getCompetences().stream().map(CVMapper::toEntity).collect(Collectors.toList()) : new ArrayList<>());

        cv.setLangues(dto.getLangues() != null ?
                dto.getLangues().stream().map(CVMapper::toEntity).collect(Collectors.toList()) : new ArrayList<>());

        cv.setCertificats(dto.getCertificats() != null ?
                dto.getCertificats().stream().map(CVMapper::toEntity).collect(Collectors.toList()) : new ArrayList<>());

        cv.setDiplomes(dto.getDiplomes() != null ?
                dto.getDiplomes().stream().map(CVMapper::toEntity).collect(Collectors.toList()) : new ArrayList<>());

        // Set parent CV reference in children
        cv.getExperiences().forEach(e -> e.setCv(cv));
        cv.getCompetences().forEach(c -> c.setCv(cv));
        cv.getLangues().forEach(l -> l.setCv(cv));
        cv.getCertificats().forEach(c -> c.setCv(cv));
        cv.getDiplomes().forEach(d -> d.setCv(cv));

        return cv;
    }

    public static Experience toEntity(ExperienceDto dto) {
        Experience entity = new Experience();
        entity.setType(dto.getType());
        entity.setDateDebut(dto.getDateDebut());
        entity.setDateFin(dto.getDateFin());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public static Competence toEntity(CompetenceDto dto) {
        Competence entity = new Competence();
        entity.setNom(dto.getNom());
        entity.setDescription(dto.getDescription());
        entity.setPourcentage(dto.getPourcentage());
        return entity;
    }

    public static Langue toEntity(LangueDto dto) {
        Langue entity = new Langue();
        entity.setNom(dto.getNom());
        entity.setNiveau(dto.getNiveau());
        entity.setIsMaitrise(dto.getIsMaitrise());
        return entity;
    }

    public static Certificat toEntity(CertificatDto dto) {
        Certificat entity = new Certificat();
        entity.setTitre(dto.getTitre());
        entity.setOrganisation(dto.getOrganisation());
        entity.setDateDelivrance(dto.getDateDelivrance());
        entity.setStatut(dto.getStatut());
        return entity;
    }

    public static Diplome toEntity(DiplomeDto dto) {
        Diplome entity = new Diplome();
        entity.setTitre(dto.getTitre());
        entity.setInstitution(dto.getInstitution());
        entity.setDateDelivrance(dto.getDateDelivrance());
        entity.setStatut(dto.getStatut());
        return entity;
    }
}

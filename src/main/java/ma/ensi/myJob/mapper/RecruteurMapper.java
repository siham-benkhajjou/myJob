package ma.ensi.myJob.mapper;

import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;

public class RecruteurMapper {

    public static RecruteurDto toDto(Recruteur r) {
        RecruteurDto dto = new RecruteurDto();
        dto.setEmail(r.getEmail());
        dto.setNom(r.getNom());
        dto.setPrenom(r.getPrenom());
        dto.setLinkedin(r.getLinkedin());
        dto.setNomEntreprise(r.getNomEntreprise());
        dto.setPoste(r.getPoste());
        dto.setLogoEntreprise(r.getLogoEntreprise());
        dto.setSecteur(r.getSecteur());
        dto.setAdresse(r.getAdresse());
        dto.setSiteWeb(r.getSiteWeb());
        dto.setDescription(r.getDescription());
        return dto;
    }

    public static void updateEntityFromDto(RecruteurDto dto, Recruteur r) {
        r.setEmail(dto.getEmail());
        r.setNom(dto.getNom());
        r.setPrenom(dto.getPrenom());
        r.setLinkedin(dto.getLinkedin());
        r.setNomEntreprise(dto.getNomEntreprise());
        r.setPoste(dto.getPoste());
        r.setSecteur(dto.getSecteur());
        r.setAdresse(dto.getAdresse());
        r.setSiteWeb(dto.getSiteWeb());
        r.setDescription(dto.getDescription());
    }
}

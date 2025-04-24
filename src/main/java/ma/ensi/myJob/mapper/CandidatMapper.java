package ma.ensi.myJob.mapper;

import ma.ensi.myJob.DTO.CandidatDto;
import ma.ensi.myJob.entity.Candidat;

public class CandidatMapper {
    public static CandidatDto toDto(Candidat candidat) {
        CandidatDto dto = new CandidatDto();
        dto.setCin(candidat.getCin());
        dto.setEmail(candidat.getEmail());
        dto.setNom(candidat.getNom());
        dto.setPrenom(candidat.getPrenom());
        dto.setUserName(candidat.getUserName());
        dto.setFonctionnement(candidat.getFonctionnement());
        dto.setNumTele(candidat.getNumTele());
        dto.setImage(candidat.getImage());
        dto.setCv(CVMapper.toDto(candidat.getCv()));
        return dto;
    }

    public static Candidat toEntity(CandidatDto dto) {

        Candidat candidat = new Candidat();
        candidat.setCin(dto.getCin());
        candidat.setEmail(dto.getEmail());
        candidat.setNom(dto.getNom());
        candidat.setPrenom(dto.getPrenom());
        candidat.setUserName(dto.getUserName());
        candidat.setFonctionnement(dto.getFonctionnement());
        candidat.setNumTele(dto.getNumTele());
        candidat.setImage(dto.getImage());
        candidat.setCv(CVMapper.toEntity(dto.getCv()));
        return candidat;
    }

    public static void updateEntityFromDto(CandidatDto dto, Candidat candidat) {
        candidat.setCin(dto.getCin());
        candidat.setEmail(dto.getEmail());
        candidat.setNom(dto.getNom());
        candidat.setPrenom(dto.getPrenom());
        candidat.setUserName(dto.getUserName());
        candidat.setFonctionnement(dto.getFonctionnement());
        candidat.setNumTele(dto.getNumTele());
        candidat.setImage(dto.getImage());
        candidat.setCv(CVMapper.toEntity(dto.getCv()));
    }
}

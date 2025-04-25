package ma.ensi.myJob.service;

import ma.ensi.myJob.DTO.CVDto;

public interface ICVService {
    CVDto getCVById(Long id);
    CVDto saveCV(CVDto dto);
    void deleteCV(Long id);
}

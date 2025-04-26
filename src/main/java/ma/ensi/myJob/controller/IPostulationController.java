package ma.ensi.myJob.controller;

import ma.ensi.myJob.DTO.PostulationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPostulationController {
    @PostMapping
    ResponseEntity<PostulationDTO> postuler(@RequestBody PostulationDTO dto);
}

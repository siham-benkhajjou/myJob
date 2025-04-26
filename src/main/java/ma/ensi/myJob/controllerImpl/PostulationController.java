package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.PostulationDTO;
import ma.ensi.myJob.Service.IPostulationService;
import ma.ensi.myJob.controller.IPostulationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostulationController implements IPostulationController {

    @Autowired
    private IPostulationService postulationService;

    @Override
    public ResponseEntity<PostulationDTO> postuler(PostulationDTO dto) {
        return ResponseEntity.ok(postulationService.postuler(dto));
    }


}

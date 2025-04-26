package ma.ensi.myJob.controllerImpl;

import ma.ensi.myJob.DTO.PostulationDTO;
import ma.ensi.myJob.Service.IPostulationService;
import ma.ensi.myJob.serviceImpl.PostulationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/postulations")
public class PostulationControllerImpl {

    @Autowired
    private IPostulationService postulationService;

    @PostMapping
    public ResponseEntity<String> postuler(@RequestBody PostulationDTO dto) {
        postulationService.postuler(dto);
        return ResponseEntity.ok("✅ Postulation enregistrée");
    }
   // @Autowired
    //private PostulationServiceImpl postulationService;

    //@PostMapping
    //public ResponseEntity<Object> postuler(@RequestBody PostulationDTO dto) {
     //   postulationService.postuler(dto);
     //   return ResponseEntity.ok().build();
   // }

}

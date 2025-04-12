package ma.ensi.myJob.controller;


import ma.ensi.myJob.DTO.RecruteurDto;
import ma.ensi.myJob.entity.Recruteur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IRecruteurController {
    @PostMapping("/register")
    public ResponseEntity<Recruteur> register(@RequestBody RecruteurDto dto) ;

    @PostMapping
    public ResponseEntity<Recruteur> createRecruteur(@RequestBody Recruteur recruteur);

    @GetMapping
    public ResponseEntity<List<Recruteur>> getAllRecruteurs() ;

    @GetMapping("/{id}")
    public ResponseEntity<Recruteur> getRecruteurById(@PathVariable Long id) ;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruteur(@PathVariable Long id) ;

    @PutMapping("/{id}")
    ResponseEntity<Recruteur> updateRecruteur(@PathVariable Long id, @RequestBody RecruteurDto dto);

}

package com.bebesuivi.Controller;

import com.bebesuivi.Modele.Rendez_vous;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Service.Rendez_vousService;
import com.bebesuivi.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("rendez-vous")
@AllArgsConstructor

public class Rendez_vousControleur {
    private final Rendez_vousService rendezVousService;

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Rendez_vous> createRdv(@Valid @RequestBody Rendez_vous rendez_vous){
        return new ResponseEntity<>(rendezVousService.createRdv(rendez_vous), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/read")
    public ResponseEntity<List<Rendez_vous>> getRdv(){
        return new ResponseEntity<>(rendezVousService.getAllRdv(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("/read/{id}")
    // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<Rendez_vous> getRdvById(@Valid @PathVariable long id){
        return new ResponseEntity<>(rendezVousService.getRdvById(id),HttpStatus.OK) ;}
    @CrossOrigin
    @PutMapping("/update")
    //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<Rendez_vous>  editRdv(@Valid @RequestBody Rendez_vous rendez_vous){
        return new ResponseEntity<>( rendezVousService.editRdv(rendez_vous),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteRdvById(@Valid @PathVariable Long idRdv){
        return new ResponseEntity<>(rendezVousService.deleteRdvById(idRdv),HttpStatus.OK);}
}

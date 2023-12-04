package com.bebesuivi.Controller;

import com.bebesuivi.Modele.Docteur;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Service.DocteurService;
import com.bebesuivi.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("docteur")
@AllArgsConstructor

public class DocteurControleur {
    private final DocteurService docteurService;
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Docteur> createDocteur(@Valid @RequestBody Docteur docteur){
        return new ResponseEntity<>(docteurService.createDocteur(docteur), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/read") public ResponseEntity<List<Docteur>> getdocteur(){
        return new ResponseEntity<>(docteurService.getAllDocteur(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("/read/{id}")
    // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<Docteur> getDocteurById(@Valid @PathVariable long id){
        return new ResponseEntity<>(docteurService.getDocteurById(id),HttpStatus.OK) ;}
    @CrossOrigin
    @PutMapping("/update")
    //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<Docteur>  editDocteur(@Valid @RequestBody Docteur docteur){
        return new ResponseEntity<>( docteurService.editdocteur(docteur),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteDocteurById(@Valid @RequestBody Docteur docteur){
        return new ResponseEntity<>(docteurService.deleteDocteurById(docteur),HttpStatus.OK);}
    @CrossOrigin
    @PostMapping("/login")
    // @Operation(summary = "Connexion d'un utilisateur")
    public Object connexion(@RequestParam("email") String email,@RequestParam("motDePasse") String motDePasse) {
        System.out.println(email);
        System.out.println(motDePasse);
        return docteurService.connectionDocteur(email, motDePasse);
    }
    @CrossOrigin
    @PutMapping("/validate/{id}")
    public ResponseEntity<String> validateDoctor(@PathVariable Long id) {
        docteurService.validateDoctor(id);
        return ResponseEntity.ok("Doctor validated successfully");
    }
}

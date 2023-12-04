package com.bebesuivi.Controller;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.Medicament;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Repository.GrossesseRepository;
import com.bebesuivi.Service.GrossesseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("grossesse")
@AllArgsConstructor

public class GrossesseControleur {
    @Autowired
      GrossesseService grossesseService;
@Autowired
    GrossesseRepository grossesseRepository;
    @PostMapping("/create")
    public ResponseEntity<Grossesse> createGrossesse(@Valid @RequestBody Grossesse grossesse){
        return new ResponseEntity<>(grossesseService.createGrossesse(grossesse), HttpStatus.OK);

    }
    @CrossOrigin
    @GetMapping("/read")
    public ResponseEntity<List<Grossesse>> getgrossesse(){
        return new ResponseEntity<>(grossesseService.getAllGrossesse(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("read/user/{idUser}")
    public ResponseEntity<List<Grossesse>> getAllGrossesseByIdUser(@PathVariable Long idUser) {
        try {
            List<Grossesse> grossesses = grossesseService.getAllGrossesseByIdUser(idUser);
            return new ResponseEntity<>(grossesses, HttpStatus.OK);
        } catch (NoContentException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }}


    @CrossOrigin
    @GetMapping("/readEnCours/{userId}")
    // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<Grossesse> getGrossessesEnCours(@PathVariable long userId) {
        try {
            Grossesse currentGrossesse = grossesseService.getGrossessesEnCours(userId);
            return ResponseEntity.ok(currentGrossesse);
        } catch (NoContentException e) {
            return ResponseEntity.noContent().build();
        }
    }
    @CrossOrigin
    @PutMapping("/update")
    //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<Grossesse>  editGrossesse(@Valid @RequestBody Grossesse grossesse){
        return new ResponseEntity<>( grossesseService.editGrossesse(grossesse),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteGrossesseById(@Valid @PathVariable Long id){
        return new ResponseEntity<>(grossesseService.deleteGrossesseById(id),HttpStatus.OK);}
}
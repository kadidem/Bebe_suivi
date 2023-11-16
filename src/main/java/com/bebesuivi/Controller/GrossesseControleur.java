package com.bebesuivi.Controller;

import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.Medicament;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Service.GrossesseService;
import lombok.AllArgsConstructor;
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
    private final GrossesseService grossesseService;

    @PostMapping("/create")
    public ResponseEntity<Grossesse> createGrossesse(@Valid @RequestBody Grossesse grossesse){
        return new ResponseEntity<>(grossesseService.createGrossesse(grossesse), HttpStatus.OK);

    }
    @CrossOrigin
    @GetMapping("/read")
    public ResponseEntity<List<Grossesse>> getgrossesse(){
        return new ResponseEntity<>(grossesseService.getAllGrossesse(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("/read/{id}")
    // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<Grossesse> getGrossesseById(@Valid @PathVariable long id){
        return new ResponseEntity<>(grossesseService.getGrossesseById(id),HttpStatus.OK) ;}
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
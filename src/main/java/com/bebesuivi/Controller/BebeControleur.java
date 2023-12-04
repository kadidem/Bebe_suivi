package com.bebesuivi.Controller;

import com.bebesuivi.Modele.Bebe;
import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Service.BebeService;
import com.bebesuivi.Service.GrossesseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("bebe")
@AllArgsConstructor
public class BebeControleur {
    private final BebeService bebeService;

    @PostMapping("/create")
    public ResponseEntity<Bebe> createBebe(@Valid @RequestBody Bebe bebe){
        return new ResponseEntity<>(bebeService.createBebe(bebe), HttpStatus.OK);

    }
    @CrossOrigin
    @GetMapping("/read")
    public ResponseEntity<List<Bebe>> getbebe(){
        return new ResponseEntity<>(bebeService.getAllBebe(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("/read/{id}")
    // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<Bebe> getBebeById(@Valid @PathVariable long id){
        return new ResponseEntity<>(bebeService.getBebeById(id),HttpStatus.OK) ;}
    @GetMapping("/read/user/{idUser}")
    public  ResponseEntity<List<Bebe>> getbebebyuser(@Valid @PathVariable long idUser){
        return new ResponseEntity<>(bebeService.getAllBebeByUser(idUser),HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/update")
    //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<Bebe>  editBebe(@Valid @RequestBody Bebe bebe){
        return new ResponseEntity<>( bebeService.editBebe(bebe),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteBebeById(@Valid @PathVariable Long id){
      return new ResponseEntity<>(bebeService.deleteBebeById(id),HttpStatus.OK);}
}

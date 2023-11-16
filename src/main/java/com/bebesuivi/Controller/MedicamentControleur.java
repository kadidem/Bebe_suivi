package com.bebesuivi.Controller;

import com.bebesuivi.Modele.Medicament;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Service.MedicamentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("medicament")
@AllArgsConstructor
public class MedicamentControleur {
private final MedicamentService medicamentService;
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Medicament> createMedicament(@Valid @RequestBody Medicament medicament){
        return new ResponseEntity<>(medicamentService.createMedicament(medicament), HttpStatus.OK);
    }
    @GetMapping("/read")
    public ResponseEntity<List<Medicament>> getmedicament(){
        return new ResponseEntity<>(medicamentService.getAllMedicament(),HttpStatus.OK);}
    @GetMapping("/read/{id}")
    // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<Medicament> getMedicamentById(@Valid @PathVariable long id){
        return new ResponseEntity<>(medicamentService.getMedicamentById(id),HttpStatus.OK) ;}
    @CrossOrigin
    @PutMapping("/update")
    //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<Medicament>  editMedicament(@Valid @RequestBody Medicament medicament){
        return new ResponseEntity<>( medicamentService.editMedicament(medicament),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteMedicamentById(@Valid @PathVariable Long id){
        return new ResponseEntity<>(medicamentService.deleteMedicamentById(id),HttpStatus.OK);}
}

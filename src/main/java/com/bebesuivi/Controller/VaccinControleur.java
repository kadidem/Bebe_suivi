package com.bebesuivi.Controller;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Modele.Vaccin;
import com.bebesuivi.Service.VaccinService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("vaccin")
@AllArgsConstructor
public class VaccinControleur {
    @Autowired
    private final VaccinService vaccinService;
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Vaccin> createVaccin(@Valid @RequestBody Vaccin vaccin){
        return new ResponseEntity<>(vaccinService.createVaccin(vaccin), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/read")
    public ResponseEntity<List<Vaccin>> getvaccin(){
        return new ResponseEntity<>(vaccinService.getAllVaccin(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("read/bebe/{idBebe}")
    public ResponseEntity<List<Vaccin>> getAllVaccinByIdVaccin(@PathVariable Long idVaccin) {
        try {
            List<Vaccin> vaccins = vaccinService.getAllVaccinByIdBebe(idVaccin);
            return new ResponseEntity<>(vaccins, HttpStatus.OK);
        } catch (NoContentException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }}
    @CrossOrigin
    @PutMapping("/update")
    //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<Vaccin>  editVaccin(@Valid @RequestBody Vaccin vaccin){
        return new ResponseEntity<>( vaccinService.editvaccin(vaccin),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteVaccinById(@Valid @PathVariable Long id){
        return new ResponseEntity<>(vaccinService.deleteVaccinById(id),HttpStatus.OK);}}

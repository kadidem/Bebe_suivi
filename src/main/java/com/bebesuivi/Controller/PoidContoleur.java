package com.bebesuivi.Controller;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Poid;
import com.bebesuivi.Modele.Vaccin;
import com.bebesuivi.Service.PoidService;
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
@RequestMapping("poid")
@AllArgsConstructor

public class PoidContoleur {
    @Autowired
    private final PoidService poidService;
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Poid> createPoid(@Valid @RequestBody Poid poid){
        return new ResponseEntity<>(poidService.createPoid(poid), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/read")
    public ResponseEntity<List<Poid>> getpoid(){
        return new ResponseEntity<>(poidService.getAllPoid(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("read/bebe/{idBebe}")
    public ResponseEntity<List<Poid>> getAllPoidByIdPoid(@PathVariable Long idPoid) {
        try {
            List<Poid> poids = poidService.getAllPoidByIdBebe(idPoid);
            return new ResponseEntity<>(poids, HttpStatus.OK);
        } catch (NoContentException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }}
    @CrossOrigin
    @PutMapping("/update")
    //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<Poid>  editPoid(@Valid @RequestBody Poid poid){
        return new ResponseEntity<>( poidService.editpoid(poid),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deletePoidById(@Valid @PathVariable Long id){
        return new ResponseEntity<>(poidService.deletePoidById(id),HttpStatus.OK);}}



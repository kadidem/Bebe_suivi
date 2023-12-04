package com.bebesuivi.Controller;

import com.bebesuivi.Modele.Admin;
import com.bebesuivi.Modele.Docteur;
import com.bebesuivi.Service.AdminService;
import com.bebesuivi.Service.DocteurService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("Admin")
@AllArgsConstructor

public class AdminControleur {
    private final AdminService adminService;
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin){
        return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/read") public ResponseEntity<List<Admin>> getdocteur(){
        return new ResponseEntity<>(adminService.getAllAdmin(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("/read/{id}")
    // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<Admin> getAdminById(@Valid @PathVariable long id){
        return new ResponseEntity<>(adminService.getAdminById(id),HttpStatus.OK) ;}
    @CrossOrigin
    @PutMapping("/update")
    //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<Admin>  editAdmin(@Valid @RequestBody Admin admin){
        return new ResponseEntity<>( adminService.editadmin(admin),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteAdminById(@Valid @RequestBody Admin admin){
        return new ResponseEntity<>(adminService.deleteAdminById(admin),HttpStatus.OK);}
    @CrossOrigin
    @PostMapping("/login")
    // @Operation(summary = "Connexion d'un utilisateur")
    public Object connexion(@RequestParam("email") String email,@RequestParam("motDePasse") String motDePasse) {
        System.out.println(email);
        System.out.println(motDePasse);
        return adminService.connectionAdmin(email, motDePasse);
    }
}

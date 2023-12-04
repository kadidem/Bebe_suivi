package com.bebesuivi.Controller;


import com.bebesuivi.Modele.User;
import com.bebesuivi.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/read")
    public ResponseEntity<List<User>> getuser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);}
    @CrossOrigin
    @GetMapping("/read/{id}")
   // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<User> getUserById(@Valid @PathVariable long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK) ;}
    @CrossOrigin
    @PutMapping("/update")
  //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<User>  editUtilisateur(@Valid @RequestBody User user){
        return new ResponseEntity<>( userService.editutilisateur(user),HttpStatus.OK);}
    @CrossOrigin
    @DeleteMapping("/delete")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteUserById(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.deleteUserById(user),HttpStatus.OK);}
    @CrossOrigin
    @PostMapping("/login")
   // @Operation(summary = "Connexion d'un utilisateur")
    public Object connexion(@RequestParam("email") String email,@RequestParam("motDePasse") String motDePasse) {
        System.out.println(email);
        System.out.println(motDePasse);
        return userService.connectionUser(email, motDePasse);
    }
//    @PostMapping("/{userId}/addDocteurs")
//    public ResponseEntity<String> ajouterDocteursAUtilisateur(
//            @PathVariable Long userId,
//            @RequestBody List<Docteur> docteurs) {
//
//        userService.ajouterDocteursAUtilisateur(userId, docteurs);
//
//        return ResponseEntity.ok("Docteurs ajoutés avec succès à l'utilisateur avec l'ID : " + userId);
//    }
}

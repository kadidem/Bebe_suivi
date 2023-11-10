package com.bebesuivi.Controller;

import com.bebesuivi.Modele.User;
import com.bebesuivi.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
    @GetMapping("/read")
    public ResponseEntity<List<User>> getuser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);}
    @GetMapping("/read/{id}")
   // @Operation(summary = "Affichage  d'un utilisateur")
    public ResponseEntity<User> getUserById(@Valid @PathVariable long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK) ;}
    @PutMapping("/update")
  //  @Operation(summary = "Modification d'un utilisateur")
    public ResponseEntity<User>  editUtilisateur(@Valid @RequestBody User user){
        return new ResponseEntity<>( userService.editutilisateur(user),HttpStatus.OK);}
    @DeleteMapping("/delete")
    //@Operation(summary = "Suppression d'un utilisateur")
    public ResponseEntity<String> deleteUserById(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.deleteUserById(user),HttpStatus.OK);}
    @PostMapping("/login")
   // @Operation(summary = "Connexion d'un utilisateur")
    public Object connexion(@RequestParam("email") String email,@RequestParam("motDePasse") String motDePasse) {
        System.out.println(email);
        System.out.println(motDePasse);
        return userService.connectionUser(email, motDePasse);
    }
}

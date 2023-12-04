//package com.bebesuivi.Controller;
//
//import com.bebesuivi.Modele.Docteur;
//import com.bebesuivi.Modele.MesDocteurs;
//import com.bebesuivi.Modele.User;
//import com.bebesuivi.Service.DocteurService;
//import com.bebesuivi.Service.MesDocteurService;
//import com.bebesuivi.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/mesdocteurs")
//public class MesDocteurControleur {
//
//    private final MesDocteurService mesDocteurService;
//    private final UserService userService;
//
//private final DocteurService docteurService;
//    @Autowired
//    public MesDocteurControleur(MesDocteurService mesDocteurService, UserService userService,DocteurService docteurService) {
//        this.mesDocteurService = mesDocteurService;
//        this.userService = userService;
//        this.docteurService = docteurService;
//    }
//
//    @PostMapping("/add-to-favorites")
//    public ResponseEntity<String> addToFavorites(@RequestParam long userId, @RequestParam long docteurId) {
//        try {
//            User user = userService.getUserById(userId);
//            Docteur docteur = docteurService.getDocteurById(docteurId);
//
//            if (user != null && docteur != null) {
//                mesDocteurService.addToFavorites(user, docteur);
//                return ResponseEntity.ok("Doctor added to favorites successfully");
//            } else {
//                return ResponseEntity.badRequest().body("Invalid user or doctor");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Internal Server Error");
//        }
//    }
//}

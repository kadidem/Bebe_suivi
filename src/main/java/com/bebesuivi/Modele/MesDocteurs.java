//package com.bebesuivi.Modele;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Data;
//
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//@Data
//@Entity
//public class MesDocteurs {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "docteur_id")
//    private Docteur docteur;
//}

//package com.bebesuivi.Service;
//
//import com.bebesuivi.Modele.Docteur;
//import com.bebesuivi.Modele.MesDocteurs;
//import com.bebesuivi.Modele.User;
//import com.bebesuivi.Repository.MesDocteurRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MesDocteurService {
//    @Autowired
//    private final MesDocteurRepository mesDocteurRepository;
//    @Autowired
//    public MesDocteurService(MesDocteurRepository mesDocteurRepository) {
//        this.mesDocteurRepository = mesDocteurRepository;
//    }
//
//    public void addToFavorites(User user, Docteur docteur) {
//        MesDocteurs mesDocteur = new MesDocteurs();
//        mesDocteur.setUser(user);
//        mesDocteur.setDocteur(docteur);
//
//
//
//        mesDocteurRepository.save(mesDocteur);
//    }
//}

package com.bebesuivi.Service;

import com.bebesuivi.Exception.BadRequestException;
import com.bebesuivi.Modele.Docteur;
import com.bebesuivi.Modele.NotificationAdmin;
import com.bebesuivi.Modele.NotificationDocteur;
import com.bebesuivi.Repository.NotificationDocteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationDocteurService {

    @Autowired
    private NotificationDocteurRepository notificationDocteurRepository;


    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String sender;

    public void sendDoctorEmail(Docteur docteur) {
        NotificationDocteur notificationDocteur = new NotificationDocteur();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
String msg ="Bonjour, merci de vous être inscrit. Votre compte est en attente de validation. Vous recevrez bientôt une confirmation.";
        notificationDocteur.setTexte(msg);

        try {
            mailMessage.setFrom(sender);
            mailMessage.setTo(docteur.getEmail()); // Remplacez par l'e-mail de l'administrateur
            mailMessage.setSubject("Confirmation d'inscription");
            mailMessage.setText("Bonjour, merci de vous être inscrit. Votre compte est en attente de validation. Vous recevrez bientôt une confirmation.");


            javaMailSender.send(mailMessage);

            // Enregistrez la notification dans la base de données si nécessaire
            notificationDocteur.setDate(LocalDateTime.now());
            notificationDocteur.setDocteur(docteur);
            notificationDocteurRepository.save(notificationDocteur);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }


}

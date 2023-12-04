package com.bebesuivi.Service;

import com.bebesuivi.Exception.BadRequestException;
import com.bebesuivi.Modele.Docteur;
import com.bebesuivi.Modele.NotificationAdmin;
import com.bebesuivi.Repository.NotificationAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NotificationAdminService {
    @Autowired
    private NotificationAdminRepository notificationAdminRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    String sender;

    public void sendDoctorRegistrationEmail(Docteur docteur) {
        NotificationAdmin notificationAdmin = new NotificationAdmin();
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        String msg = "Demande de validation d'un nouveau docteur:\n"
                + "Nom: " + docteur.getNomPrenom() + "\n"

                + "Email: " + docteur.getEmail();

        notificationAdmin.setTexte(msg);

        try {
            mailMessage.setFrom(sender);
            mailMessage.setTo("kadidem1999@gmail.com"); // Remplacez par l'e-mail de l'administrateur
            mailMessage.setText(notificationAdmin.getTexte());
            mailMessage.setSubject("Nouvelle inscription de docteur");

            javaMailSender.send(mailMessage);

            // Enregistrez la notification dans la base de données si nécessaire
            notificationAdmin.setDate(LocalDateTime.now());

            notificationAdminRepository.save(notificationAdmin);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public void sendRegistrationConfirmation(String docteurEmail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(docteurEmail);
        mailMessage.setSubject("Confirmation d'inscription");
        mailMessage.setText("Bonjour, merci de vous être inscrit. Votre compte est en attente de validation. Vous recevrez bientôt une confirmation.");

        try {
            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            throw new BadRequestException("Erreur lors de l'envoi de l'e-mail de confirmation d'inscription.");
        }
    }
}

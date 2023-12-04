package com.bebesuivi.Service;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Docteur;
import com.bebesuivi.Modele.NotificationAdmin;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Repository.DocteurRepository;
import com.bebesuivi.Repository.NotificationAdminRepository;
import com.bebesuivi.Repository.NotificationDocteurRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DocteurService {
    private final DocteurRepository docteurRepository;
    private final NotificationAdminService notificationAdminService;
    private final NotificationDocteurService notificationDocteurService;
    @Autowired
    public DocteurService(DocteurRepository docteurRepository, NotificationAdminService notificationAdminService,NotificationDocteurService notificationDocteurService) {
        this.docteurRepository = docteurRepository;
        this.notificationAdminService = notificationAdminService;
        this.notificationDocteurService =notificationDocteurService;
    }
    @Autowired
    private NotificationAdminRepository notificationAdminRepository;
    private NotificationDocteurRepository notificationDocteurRepository;
    public Docteur createDocteur(Docteur docteur) {
        if (docteurRepository.findByEmail(docteur.getEmail()) == null) {
            docteur.setValide(false);
            Docteur nouveauDocteur = docteurRepository.save(docteur);
            notificationAdminService.sendDoctorRegistrationEmail(nouveauDocteur);
            notificationDocteurService.sendDoctorEmail(nouveauDocteur);
            return nouveauDocteur;
        } else {
            throw new EntityExistsException("Cet email existe déjà");
        }
    }
    public List<Docteur> getAllDocteur(){

        List<Docteur> docteurs = docteurRepository.findAll();
        if (docteurs.isEmpty())
            throw new NoContentException("Aucun docteur trouvé");
        return docteurs;
    }
    public Docteur getDocteurById(long idDocteur){

        Docteur docteur= docteurRepository.findByIdDocteur(idDocteur);
        if(docteur ==null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return docteur;
    }

    public Docteur editdocteur(Docteur docteur){
        Docteur docteur1= docteurRepository.findByIdDocteur(docteur.getIdDocteur());
        if (docteur1 == null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return docteurRepository.save(docteur);

    }
    public String deleteDocteurById(Docteur docteur){
        Docteur docteur1= docteurRepository.findByIdDocteur(docteur.getIdDocteur());
        if (docteur1 == null)
            throw new EntityNotFoundException("Désolé  l'utilisateur à supprimé n'existe pas");
        docteurRepository.delete(docteur);
        return "Utilisateur Supprimé";
    }
    public Docteur connectionDocteur(String email, String motDePasse) {
        Docteur docteur = docteurRepository.findByEmailAndMotDePasse(email, motDePasse);
        if (!docteur.isValide()) {
            throw new EntityNotFoundException("Votre compte n'est pas encore validé par l'administrateur.");
        }
        if (docteur == null) {
            throw new EntityNotFoundException("Cet utilisateur n'existe pas");
        }
        if (!docteur.getMotDePasse().equals(motDePasse)) {
            throw new EntityNotFoundException("Mot de passe incorrect");
        }

        // Authentification réussie, retourner l'utilisateur
        return docteur;
    }
    public void validateDoctor(Long id) {
        Docteur docteur = getDocteurById(id);
        boolean newValidationStatus = !docteur.isValide();
        docteur.setValide(newValidationStatus);
        docteurRepository.save(docteur);
    }
}

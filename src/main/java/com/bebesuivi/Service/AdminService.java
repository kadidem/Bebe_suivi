package com.bebesuivi.Service;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.Admin;
import com.bebesuivi.Repository.AdminRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AdminService {
  @Autowired
    private final AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @PostConstruct
    public void init() {
        // Créer un administrateur au démarrage de l'application
        Admin admin = new Admin();
        admin.setEmail("kadidem1999@gmail.com");
        admin.setMotDePasse("kadidem");
        admin.setNomPrenom("Kadidia mah Dembele");
        Admin existingAdmin = adminRepository.findByEmail(admin.getEmail());
        if (existingAdmin == null) {
            // L'administrateur n'existe pas, donc nous le créons
            adminRepository.save(admin);
        } else {

            System.out.println("L'administrateur avec l'email " + admin.getEmail() + " existe déjà.");
        }
    }
    public Admin createAdmin(Admin admin) {
        if (adminRepository.findByEmail(admin.getEmail()) == null) {
            return adminRepository.save(admin);}
        else {
            throw new EntityExistsException("Cet email existe déjà");}}
    public List<Admin> getAllAdmin(){

        List<Admin> admins = adminRepository.findAll();
        if (admins.isEmpty())
            throw new NoContentException("Aucun utilisateur trouvé");
        return admins;
    }
    public Admin getAdminById(long idAdmin){

        Admin admin= adminRepository.findByIdAdmin(idAdmin);
        if(admin ==null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return admin;
    }

    public Admin editadmin(Admin admin){
        Admin admins= adminRepository.findByIdAdmin(admin.getIdAdmin());
        if (admins == null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return adminRepository.save(admin);

    }
    public String deleteAdminById(Admin admin){
        Admin utilisateur= adminRepository.findByIdAdmin(admin.getIdAdmin());
        if (utilisateur == null)
            throw new EntityNotFoundException("Désolé  l'utilisateur à supprimé n'existe pas");
        adminRepository.delete(admin);
        return "Utilisateur Supprimé";
    }
    public Admin connectionAdmin(String email, String motDePasse) {
        Admin utilisateur = adminRepository.findByEmailAndMotDePasse(email, motDePasse);
        if (utilisateur == null) {
            throw new EntityNotFoundException("Cet utilisateur n'existe pas");
        }
        if (!utilisateur.getMotDePasse().equals(motDePasse)) {
            throw new EntityNotFoundException("Mot de passe incorrect");
        }

        // Authentification réussie, retourner l'utilisateur
        return utilisateur;
    }
}

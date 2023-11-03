package com.bebesuivi.Service;

import com.bebesuivi.Exception.NoContentException;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            return userRepository.save(user);}
            else {
            throw new EntityExistsException("Cet email existe déjà");}}
    public List<User> getAllUser(){

        List<User> users = userRepository.findAll();
        if (users.isEmpty())
            throw new NoContentException("Aucun utilisateur trouvé");
        return users;
    }
    public User getUserById(long idUser){

        User user= userRepository.findByIdUser(idUser);
        if(user ==null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return user;
    }

    public User editutilisateur(User user){
        User utilisateur= userRepository.findByIdUser(user.getIdUser());
        if (utilisateur == null)
            throw new EntityNotFoundException("cet utilisateur n'existe pas");
        return userRepository.save(user);

    }
    public String deleteUserById(User user){
        User utilisateur= userRepository.findByIdUser(user.getIdUser());
        if (utilisateur == null)
            throw new EntityNotFoundException("Désolé  l'utilisateur à supprimé n'existe pas");
        userRepository.delete(user);
        return "Utilisateur Supprimé";
    }
    public User connectionUser(String email, String motDePasse) {
        User utilisateur = userRepository.findByEmailAndMotDePasse(email, motDePasse);
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

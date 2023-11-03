package com.bebesuivi.Repository;

import com.bebesuivi.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    public User findByEmailAndMotDePasse(String email, String mot_de_passe);
    User findByIdUser(long id);

}

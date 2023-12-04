package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Admin;
import com.bebesuivi.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findByEmail(String email);
    public Admin findByEmailAndMotDePasse(String email, String mot_de_passe);
    Admin findByIdAdmin(long id);
}

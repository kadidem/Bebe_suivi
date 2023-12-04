package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Docteur;
import com.bebesuivi.Modele.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocteurRepository extends JpaRepository< Docteur ,Long> {
    public Docteur findByEmail(String email);
    public Docteur findByEmailAndMotDePasse(String email, String mot_de_passe);
    Docteur findByIdDocteur(long id);
    //void updateValidationStatus(Long idDocteur, boolean valid);
}

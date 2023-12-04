package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Bebe;
import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.User;
import com.bebesuivi.Modele.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinRepository extends JpaRepository<Vaccin, Long> {
    public Vaccin findByNom(String nom);
    Vaccin findByIdVaccin(long idVaccin);
    List<Vaccin> findByBebe_IdBebe(long idBebe);

}

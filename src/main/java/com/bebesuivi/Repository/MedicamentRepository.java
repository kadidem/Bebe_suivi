package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.Medicament;
import com.bebesuivi.Modele.Rendez_vous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
    public Medicament findByNom(String nom);

    Medicament findByIdMedicament(long idMedicaement);
    List<Medicament> findByUser_IdUser(long idUser);
}

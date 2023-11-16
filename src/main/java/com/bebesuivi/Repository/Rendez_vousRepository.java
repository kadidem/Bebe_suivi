package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Modele.Rendez_vous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface Rendez_vousRepository  extends JpaRepository<Rendez_vous, Long> {
    Rendez_vous findBydateRdv(LocalDate dateRdv);

    Rendez_vous findByIdRdv(long idRdv);


    // boolean existDateRdv(LocalDate dateRdv);
}

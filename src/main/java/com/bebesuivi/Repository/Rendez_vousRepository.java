package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Rendez_vous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface Rendez_vousRepository  extends JpaRepository<Rendez_vous, Long> {
    Rendez_vous findBydateRdv(LocalDate dateRdv);

    Rendez_vous findByIdRdv(long idRdv);


    // boolean existDateRdv(LocalDate dateRdv);
}

package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Grossesse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface GrossesseRepository extends JpaRepository <Grossesse, Long> {
    boolean existsByDateAcouchement(LocalDate dateAcouchement);

    Grossesse findByIdGrossesse(long idGrossesse);

    boolean existsByDateDernierRegle(LocalDate dateDernierRegle);
    Grossesse findFirstByUserIdUserOrderByIdGrossesseDesc(long idGrossesse);
}


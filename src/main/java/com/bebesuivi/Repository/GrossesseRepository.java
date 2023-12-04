package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Grossesse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface GrossesseRepository extends JpaRepository <Grossesse, Long> {
    boolean existsByDateAcouchement(LocalDate dateAcouchement);

    Grossesse findByIdGrossesse(long idGrossesse);

    boolean existsByDateDernierRegle(LocalDate dateDernierRegle);
    Grossesse findFirstByUserIdUserOrderByIdGrossesseDesc(long idGrossesse);
    List<Grossesse> findByUser_IdUser(long idUser);

    Grossesse findByUserIdUserAndDateAcouchementIsAfter(long idUser, LocalDate now);
}


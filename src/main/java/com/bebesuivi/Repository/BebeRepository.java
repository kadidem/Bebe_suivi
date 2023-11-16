package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Bebe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebeRepository extends JpaRepository<Bebe, Long> {
    Bebe findByNomPrenom(String nomPrenom);

    Bebe findByIdBebe(long idBebe);
}

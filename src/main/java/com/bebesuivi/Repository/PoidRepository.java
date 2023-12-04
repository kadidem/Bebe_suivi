package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Poid;
import com.bebesuivi.Modele.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoidRepository extends JpaRepository<Poid,Long> {
    public Poid findByPoid(String poid);
    Poid findByIdPoid(long idPoid);
    List<Poid> findByBebe_IdBebe(long idBebe);
}

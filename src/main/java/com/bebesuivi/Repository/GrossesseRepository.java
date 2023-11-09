package com.bebesuivi.Repository;

import com.bebesuivi.Modele.Grossesse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrossesseRepository extends JpaRepository <Grossesse, Long> {
}

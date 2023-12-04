package com.bebesuivi.Repository;

import com.bebesuivi.Modele.NotificationDocteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDocteurRepository extends JpaRepository<NotificationDocteur, Long> {
}

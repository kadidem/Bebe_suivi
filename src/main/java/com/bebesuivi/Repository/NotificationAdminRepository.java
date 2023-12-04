package com.bebesuivi.Repository;

import com.bebesuivi.Modele.NotificationAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationAdminRepository extends JpaRepository<NotificationAdmin,Long> {
}

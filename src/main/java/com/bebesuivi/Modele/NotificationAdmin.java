package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class NotificationAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotificationadmin;
    @Column(nullable = false)
    private String texte ;
    @Column(nullable = false)
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;
}

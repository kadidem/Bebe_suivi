package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotification;
    //@NotBlank(message = "Le texte de notification ne doit pas être null")
    @Column(nullable = false)
    private String texte ;

    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

}

package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Data
public class NotificationDocteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;

    @NotBlank(message = "Le texte de notification ne doit pas être null")
    @Column(nullable = false)
    private String texte;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "idDocteur")
    private Docteur docteur;
}

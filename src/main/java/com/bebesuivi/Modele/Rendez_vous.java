package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
public class Rendez_vous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRdv;
    @Column(nullable = false, unique = true)
    private LocalDate dateRdv;
    @Column(nullable = false, unique = true)
    private LocalTime heurRdv;
    @Column(nullable = false)
    private String Descritpion;
    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "idDocteur", nullable = false)
    private Docteur docteur;
}

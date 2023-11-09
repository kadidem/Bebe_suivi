package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Grossesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGrossesse;
    @Column(nullable = false)
    private LocalDate dateDernierRegle;
    @Column(nullable = false, unique = true)
    private LocalDate dateAcouchement;
    @Column(nullable = false)
    private Integer poids;
    @Column(nullable = false)
    private Integer age;
    @ManyToOne
    private User user;
}

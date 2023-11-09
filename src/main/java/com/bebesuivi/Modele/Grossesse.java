package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Grossesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGrossesse;
    @Column(nullable = false)
    private String dateDernierRegle;
    @Column(nullable = false, unique = true)
    private String DateAcouchement;
    @Column(nullable = false)
    private Integer poids;
    @Column(nullable = false)
    private Integer age;
}

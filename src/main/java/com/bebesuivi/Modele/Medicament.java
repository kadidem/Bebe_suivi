package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMedicament;
    @Column(nullable = false, unique = true)
    private String nom;
    @Column(nullable = false)
    private Integer nombreDeFoisParJour;
    @Column(nullable = false)
    private LocalDate DateDebut;
    @Column(nullable = false)
    private Integer nbreDeJour;
    @Column(nullable = false)
    private LocalDate DateFin;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

}

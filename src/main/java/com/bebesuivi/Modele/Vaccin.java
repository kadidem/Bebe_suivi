package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class Vaccin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVaccin;
    private String nom;
    private String status;
    private Integer age;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "idBebe", nullable = false)
    private Bebe bebe;

}


package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Poid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPoid;
    private Integer age;
    private String poid;
    private String taille;
    private String tourdetete;
    @ManyToOne
    @JoinColumn(name = "idBebe", nullable = false)
    private Bebe bebe;
}

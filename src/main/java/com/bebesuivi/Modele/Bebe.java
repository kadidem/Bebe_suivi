package com.bebesuivi.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Bebe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBebe;
    @Column(nullable = false)
    private LocalDate dateNaissance;
    @Column(nullable = false)
    private String nomPrenom;
    @Column(nullable = false)
    private String sexe;

    @ManyToOne
    private Grossesse grossesse;
}

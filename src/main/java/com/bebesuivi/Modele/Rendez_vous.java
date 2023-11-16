package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Entity
@Data
public class Rendez_vous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRdv;
    @Column(nullable = false, unique = true)
    private LocalDate dateRdv;
    @Column(nullable = false)
    private String Descritpion;
  
}

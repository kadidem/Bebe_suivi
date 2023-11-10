package com.bebesuivi.Modele;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;
@Entity
@Data
public class Rendez_vous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRdv;
    @Column(nullable = false)
    private String dateRdv;
    @Column(nullable = false, unique = true)
    private String Descritpion;
  
}

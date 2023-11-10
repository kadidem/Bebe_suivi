package com.bebesuivi.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    @Column(nullable = false)
    private String nom_prenom;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String Adresse;
    @Column(nullable = false)
    private Integer Numero;
    @Column(nullable = false, unique = true)
    private String motDePasse;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Grossesse> grossesses = new ArrayList<>();
}

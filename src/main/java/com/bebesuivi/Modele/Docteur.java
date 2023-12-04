package com.bebesuivi.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
@Data
public class Docteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDocteur;
    @Column(nullable = false)
    private String nomPrenom;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String Adresse;
    @Column(nullable = false)
    private int Numero;
    @Column(nullable = false, unique = true)
    private String motDePasse;
    @Column(nullable = false)
    private String specialiter;
    @Column(nullable = false)
    private String lieuDeTravail;
    @Column(nullable = false)
    private String contactDuTravail;
    @Column(nullable = false)
    private String adresseDuTravail;
    @Column(nullable = false)
    private boolean Valide;

    @OneToMany(mappedBy = "docteur", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<NotificationDocteur> notifications;

    @OneToMany(mappedBy = "docteur", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rendez_vous> rendez_vous;
//    @ManyToOne
//    @JoinColumn(name = "idUser")
//    private User user;


}

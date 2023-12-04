package com.bebesuivi.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Grossesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idGrossesse;
    @Column(nullable = false)
    private LocalDate dateDernierRegle;
    @Column(nullable = false)
    private LocalDate dateAcouchement;
    @Column(nullable = false)
    private Integer poids;
    @Column(nullable = false)
    private Integer age;
    //@Column(nullable = false)
   // private Integer nbreGrossesse;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
    @OneToMany(mappedBy = "grossesse", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bebe> bebeList = new ArrayList<>();
}

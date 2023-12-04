package com.bebesuivi.Modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdmin;
    @Column(nullable = false)
    private String nomPrenom;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, unique = true)
    private String motDePasse;
    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<NotificationAdmin> notificationAdmins = new ArrayList<>();
}

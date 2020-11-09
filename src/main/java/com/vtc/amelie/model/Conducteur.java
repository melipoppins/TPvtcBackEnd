package com.vtc.amelie.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conducteur")
public class Conducteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConducteur;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;
/*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "conducteurs_vehicules",
            joinColumns = {@JoinColumn(name = "idConducteur")},
            inverseJoinColumns = {@JoinColumn(name = "idVehicule")}
    )
    private List<Vehicule> vehicules;
*/


    public Conducteur() {
    }

    public Conducteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Conducteur(Long idConducteur, String nom, String prenom) {
        this.idConducteur = idConducteur;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getIdConducteur() {
        return idConducteur;
    }

    public void setIdConducteur(Long idConducteur) {
        this.idConducteur = idConducteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Conducteur{" +
                "idConducteur=" + idConducteur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

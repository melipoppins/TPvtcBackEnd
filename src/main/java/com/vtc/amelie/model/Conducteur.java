package com.vtc.amelie.model;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "conducteur")
public class Conducteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conducteur;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "conducteurs_vehicules",
            joinColumns = {@JoinColumn(name = "id_conducteur")},
            inverseJoinColumns = {@JoinColumn(name = "id_vehicule")}
    )
    private List<Vehicule> vehicules;

    public Conducteur() {
    }

    public Conducteur(Long id_conducteur, String nom, String prenom) {
        this.id_conducteur = id_conducteur;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId_conducteur() {
        return id_conducteur;
    }

    public void setId_conducteur(Long id_conducteur) {
        this.id_conducteur = id_conducteur;
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

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void addVehicule (Vehicule vehicule) {
        vehicules.add(vehicule);
        vehicule.getConducteurs().add(this);
    }

    @Override
    public String toString() {
        return "Conducteur{" +
                "id_conducteur=" + id_conducteur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", vehicules=" + vehicules.stream().map(Vehicule::getMarque).collect(Collectors.toList()) +
                '}';
    }
}

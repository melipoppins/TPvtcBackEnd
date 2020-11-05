package com.vtc.amelie.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicule")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehicule;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "modele", nullable = false)
    private String modele;

    @Column(name = "couleur", nullable = false)
    private String couleur;

    @Column(name = "immatriculation", nullable = false)
    private String immatriculation;

    @ManyToMany(mappedBy = "vehicules", cascade = CascadeType.PERSIST)
    private List<Conducteur> conducteurs;

    public Vehicule() {
    }

    public Vehicule(Long id_vehicule, String marque, String modele, String couleur, String immatriculation) {
        this.id_vehicule = id_vehicule;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
    }

    public Long getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(Long id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public List<Conducteur> getConducteurs() {
        return conducteurs;
    }

    public void addConducteur(Conducteur conducteur) {
        conducteurs.add(conducteur);
        conducteur.getVehicules().add(this);
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id_vehicule=" + id_vehicule +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", couleur='" + couleur + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                '}';
    }
}

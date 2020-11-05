package com.vtc.amelie.model;

import com.vtc.amelie.model.Conducteur;
import com.vtc.amelie.model.Vehicule;

import javax.persistence.*;

@Entity
@Table(name = "emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEmprunt;

    @ManyToOne
    @JoinColumn(name = "idConducteur")
    Conducteur conducteur;

    @ManyToOne
    @JoinColumn(name = "idVehicule")
    Vehicule vehicule;

    public Emprunt() {
    }

    public Emprunt(Conducteur conducteur, Vehicule vehicule) {
        this.conducteur = conducteur;
        this.vehicule = vehicule;
    }

    public Long getIdEmprunt() {
        return idEmprunt;
    }

    public void setIdEmprunt(Long idEmprunt) {
        this.idEmprunt = idEmprunt;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "idEmprunt=" + idEmprunt +
                ", conducteur=" + conducteur +
                ", vehicule=" + vehicule +
                '}';
    }
}

package com.vtc.amelie.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "emprunt")
public class Emprunt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprunt;

    @ManyToOne
    @JoinColumn(name = "idConducteur", referencedColumnName="idConducteur")
    private Conducteur conducteur;

    @ManyToOne
    @JoinColumn(name = "idVehicule", referencedColumnName="idVehicule")
    private Vehicule vehicule;

    public Emprunt() {
    }

    public Emprunt(Long idEmprunt, Conducteur conducteur, Vehicule vehicule) {
        this.idEmprunt = idEmprunt;
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

}

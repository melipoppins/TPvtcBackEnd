package com.vtc.amelie.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "emprunt")
@AssociationOverrides({
        @AssociationOverride(name = "idConducteur", joinColumns = @JoinColumn(name = "idConducteur")),
        @AssociationOverride(name = "idVehicule", joinColumns = @JoinColumn(name = "idVehicule"))
})
public class Emprunt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idConducteur", referencedColumnName="idConducteur")
    private Conducteur conducteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVehicule", referencedColumnName="idVehicule")
    private Vehicule vehicule;

    public Emprunt() {
    }

    public Emprunt(Long id, Conducteur conducteur, Vehicule vehicule) {
        this.id = id;
        this.conducteur = conducteur;
        this.vehicule = vehicule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

package com.vtc.amelie.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmpruntKey implements Serializable {
    @Column(name = "idConducteur")
    Long idConducteur;

    @Column(name = "idVehicule")
    Long idVehicule;

    public EmpruntKey() {
    }

    public EmpruntKey(Long idConducteur, Long idVehicule) {
        this.idConducteur = idConducteur;
        this.idVehicule = idVehicule;
    }

    public Long getIdConducteur() {
        return idConducteur;
    }

    public void setIdConducteur(Long idConducteur) {
        this.idConducteur = idConducteur;
    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Long idVehicule) {
        this.idVehicule = idVehicule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpruntKey that = (EmpruntKey) o;
        return Objects.equals(idConducteur, that.idConducteur) &&
                Objects.equals(idVehicule, that.idVehicule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConducteur, idVehicule);
    }
}

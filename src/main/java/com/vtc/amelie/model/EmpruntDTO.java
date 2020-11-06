package com.vtc.amelie.model;

public class EmpruntDTO {
    private Long id;
    private Conducteur idConducteur;
    private Vehicule idVehicule;

    public EmpruntDTO() {
    }

    public EmpruntDTO(Long id, Conducteur idConducteur, Vehicule idVehicule) {
        this.id = id;
        this.idConducteur = idConducteur;
        this.idVehicule = idVehicule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conducteur getIdConducteur() {
        return idConducteur;
    }

    public void setIdConducteur(Conducteur idConducteur) {
        this.idConducteur = idConducteur;
    }

    public Vehicule getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Vehicule idVehicule) {
        this.idVehicule = idVehicule;
    }

    @Override
    public String toString() {
        return "EmpruntDTO{" +
                "id=" + id +
                ", idConducteur=" + idConducteur +
                ", idVehicule=" + idVehicule +
                '}';
    }
}

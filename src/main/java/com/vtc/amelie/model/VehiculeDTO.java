package com.vtc.amelie.model;

public class VehiculeDTO {
    private Long idVehicule;
    private String marque;
    private String modele;

    public VehiculeDTO() {
    }

    public VehiculeDTO(Long idVehicule, String marque, String modele) {
        this.idVehicule = idVehicule;
        this.marque = marque;
        this.modele = modele;
    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Long idVehicule) {
        this.idVehicule = idVehicule;
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

    @Override
    public String toString() {
        return "VehiculeDTO{" +
                "idVehicule=" + idVehicule +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                '}';
    }
}

package com.vtc.amelie.model;

public class EmpruntDTO {
    private Long id;
    private Long idConducteur;
    private Long idVehicule;

    public EmpruntDTO() {
    }

    public EmpruntDTO(Long id, Long idConducteur, Long idVehicule) {
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
    public String toString() {
        return "EmpruntDTO{" +
                "id=" + id +
                ", idConducteur=" + idConducteur +
                ", idVehicule=" + idVehicule +
                '}';
    }
}

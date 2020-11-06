package com.vtc.amelie.model;

public class ConducteurDTO {
    private Long idConducteur;
    private String nom;
    private String prenom;

    public ConducteurDTO() {
    }

    public ConducteurDTO(Long idConducteur, String nom, String prenom) {
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
        return "ConducteurDTO{" +
                "idConducteur=" + idConducteur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

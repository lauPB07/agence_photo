package com.example.gestionpojets.entity;

import java.util.Date;

public class Devis {
    private int id;
    private int projetId;
    private String numero;
    private double montant;
    private Date dateCreation;
    private int statusId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjetId() {
        return projetId;
    }

    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Devis(int id, int projetId, String numero, double montant, Date dateCreation, int statusId) {
        this.id = id;
        this.projetId = projetId;
        this.numero = numero;
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.statusId = statusId;
    }



}

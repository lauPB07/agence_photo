package com.example.gestionpojets.entity;

import java.util.Date;

public class Photo {
    private int id;
    private int projetId;
    private String chemin;
    private Date datePrise;
    private String commentaire;
    private int favori;

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

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public Date getDatePrise() {
        return datePrise;
    }

    public void setDatePrise(Date datePrise) {
        this.datePrise = datePrise;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getFavori() {
        return favori;
    }

    public void setFavori(int favori) {
        this.favori = favori;
    }

    public Photo(int id, int projetId, String chemin, Date datePrise, String commentaire, int favori) {
        this.id = id;
        this.projetId = projetId;
        this.chemin = chemin;
        this.datePrise = datePrise;
        this.commentaire = commentaire;
        this.favori = favori;
    }

}

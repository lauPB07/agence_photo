package entity;

import java.util.Date;

public class Facture {
    private int id;
    private int projetId;
    private String numero;
    private double montant;
    private Date dateEmission;
    private int paye;

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

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public int getPaye() {
        return paye;
    }

    public void setPaye(int paye) {
        this.paye = paye;
    }

    public Facture(int id, int projetId, String numero, double montant, Date dateEmission, int paye) {
        this.id = id;
        this.projetId = projetId;
        this.numero = numero;
        this.montant = montant;
        this.dateEmission = dateEmission;
        this.paye = paye;
    }

}

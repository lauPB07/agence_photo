package entity;

import java.util.Date;

public class Projet {
    private int id;
    private String titre;
    private String nomClient;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private int statutId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getStatutId() {
        return statutId;
    }

    public void setStatutId(int statutId) {
        this.statutId = statutId;
    }

    public Projet(int id, String titre, String nomClient, String description, Date dateDebut, Date dateFin, int statutId) {
        this.id = id;
        this.titre = titre;
        this.nomClient = nomClient;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statutId = statutId;
    }


}

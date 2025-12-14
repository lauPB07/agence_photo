package entity;

public class ProjetUser {
    private int projetId;
    private int userId;

    public int getProjetId() {
        return projetId;
    }

    public void setProjetId(int projetId) {
        this.projetId = projetId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ProjetUser(int projetId, int userId) {
        this.projetId = projetId;
        this.userId = userId;
    }



}

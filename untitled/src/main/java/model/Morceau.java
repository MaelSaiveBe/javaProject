package model;

import java.util.AbstractList;

public class Morceau {
    private String titre;
    private int duree;

    public Morceau(String titre, int duree) {
        this.titre = titre;
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String dureeToString() {
        return String.format("%d:%d", duree / 60, duree % 60);
    }

    public int getMinute(){
        return duree / 60;
    }

    public int getSecond(){
        return duree % 60;
    }
}

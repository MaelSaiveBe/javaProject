package model;

import java.util.AbstractList;
import java.util.Objects;

public class Morceau {
    private static int compteur = 0;


    private int id;
    private String titre;
    private int duree;

    public Morceau(String titre, int duree) {
        this.titre = titre;
        this.id = ++compteur;
        this.duree = duree;
    }

    public int getId() {
        return id;
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
        return String.format("%02d:%02d", duree / 60, duree % 60);
    }

    public int getMinute() {
        return duree / 60;
    }

    public int getSecond() {
        return duree % 60;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Morceau other = (Morceau) obj;
        return this.duree == other.duree &&
                this.titre.equals(other.titre);
    }

}

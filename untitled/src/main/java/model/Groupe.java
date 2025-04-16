package model;

import java.util.ArrayList;

public class Groupe {
    private String nom;
    private ArrayList<Artiste> membres;

    public Groupe(String nom, ArrayList <Artiste> membres) {
        this.nom = nom;
        for(Artiste artiste : membres) {
            this.membres.add(artiste);
        }


    }
}

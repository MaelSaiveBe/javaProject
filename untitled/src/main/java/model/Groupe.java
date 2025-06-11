package model;

import java.util.ArrayList;

public class Groupe {
    private String nom;
    private ArrayList<String> membres;

    public Groupe(String nom,ArrayList<String> membres1) {
        this.nom = nom;
        this.membres = membres1;
    }

    public Groupe(String value) {
        this.nom = value;
        this.membres = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<String> getMembres() {
        return membres;
    }

    /**
     * Définit la liste des membres pour ce groupe. La liste actuelle des membres
     * est effacée et remplacée par la nouvelle liste fournie.
     *
     * @param membres La nouvelle liste de membres à associer à ce groupe.
     */
    public void setMembres(ArrayList<String> membres) {
        this.membres.clear();
        this.membres = membres;
    }

    /**
     * Vérifie si deux objets de type Groupe sont égaux. Deux groupes sont considérés
     * comme égaux s'ils ont le même nom et les mêmes membres.
     *
     * @param groupe Le groupe à comparer à cet objet.
     * @return true si les deux groupes sont égaux, sinon false.
     */
    public boolean equals(Groupe groupe) {
        return this.nom.equals(groupe.getNom())&&this.membres.equals(groupe.getMembres());
    }
}

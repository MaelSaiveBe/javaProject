package model;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;

public class Album {
   private static int cpt = 0;
    private int idAlbum;
    private String nomAlbum;
    private ArrayList<Morceau> trackList;
    private Groupe groupe;
    private Date release;


    public Album(String nomAlbum,
                 ArrayList<Morceau> trackList, Groupe groupe,
                 Date release) {
        this.idAlbum = ++cpt;
        this.nomAlbum = nomAlbum;
        this.trackList = trackList != null ? trackList : new ArrayList<>();
        this.groupe = groupe;
        this.release = release;
    }

    public Album(Album albumTest)
    {

        this.nomAlbum = albumTest.getNomAlbum();
        this.trackList = trackList != null ? trackList : new ArrayList<>();
        this.trackList.clear();
        this.trackList.addAll(albumTest.getTrackList());
        this.groupe = albumTest.getGroupe();
        this.release = albumTest.getRelease();

    }

    public Album(String nomAlbum,Groupe groupe,Date release){
        this.nomAlbum = nomAlbum;
        this.groupe = groupe;
        this.release = release;
        this.trackList = new ArrayList<>();
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public String getNomAlbum() {
        return nomAlbum;
    }

    public ArrayList<Morceau> getTrackList() {
        return trackList;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public Date getRelease() {
        return release;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public void setNomAlbum(String nomAlbum) {
        this.nomAlbum = nomAlbum;
    }

    /**
     * Définit la liste des morceaux (trackList) de cet album.
     * Efface la liste courante et la remplace par le contenu de la nouvelle liste.
     *
     * @param trackList La nouvelle liste de morceaux à associer à cet album.
     */
    public void setTrackList(ArrayList<Morceau> trackList) {
        this.trackList.clear();
        this.trackList.addAll(trackList);
    }


    public int addTrack(Morceau morceau) {
        this.trackList.add(morceau);

        return trackList.size();
    }


    /**
     * Supprime un morceau de la liste des morceaux (trackList) s'il existe.
     *
     * @param morceau Le morceau à supprimer de la liste.
     * @return La taille actuelle de la liste des morceaux après suppression.
     */
    public int removeTrack(Morceau morceau) {
        if(this.trackList.contains(morceau)){
            this.trackList.remove(morceau);
        }
        return trackList.size();
    }

    /**
     * Supprime un morceau de la liste des morceaux (trackList) selon son index.
     * Si l'index est valide, le morceau correspondant est supprimé. En cas de succès, la taille de la liste est retournée.
     * Si la liste des morceaux est nulle, retourne -1.
     * Si l'index est hors des limites valides, retourne -2.
     *
     * @param index L'index du morceau à supprimer dans la liste des morceaux.
     * @return La taille actuelle de la liste des morceaux après suppression si l'opération réussit,
     *         -1 si la liste des morceaux est nulle, ou -2 si l'index est invalide.
     */
    public int removeTrack(int index) {
        if (this.trackList == null)return -1;
        if(index >= 0 && index < trackList.size() ){
            this.trackList.remove(index);
            return trackList.size();
        }else return -2;

    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

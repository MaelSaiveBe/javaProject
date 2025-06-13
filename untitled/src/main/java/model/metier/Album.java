package model.metier;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Album implements Serializable{
    static final Groupe defaultGroup = new Groupe("Default Band", new ArrayList<String>(Arrays.asList("Default Member 1", "Default Member 2")));

    private int idAlbum;
    private String nomAlbum;
    private ArrayList<Morceau> trackList;
    private Groupe groupe;
    private Date release;



    public Album(String nomAlbum,
                 ArrayList<Morceau> trackList, Groupe groupe,
                 Date release) {
        this.idAlbum = -1; // Default value, can be set later
        this.nomAlbum = nomAlbum;
        this.trackList = trackList != null ? trackList : new ArrayList<>();
        this.groupe = groupe;
        this.release = release;

    }

    public Album(Album albumTest)
    {
        this.idAlbum = albumTest.getIdAlbum();
        this.nomAlbum = albumTest.getNomAlbum();
        this.trackList = trackList != null ? trackList : new ArrayList<>();
        this.trackList.clear();
        this.trackList.addAll(albumTest.getTrackList());
        this.groupe = albumTest.getGroupe();
        this.release = albumTest.getRelease();

    }

    public Album(String nomAlbum,Groupe groupe,Date release){
        this.idAlbum = -1;
        this.nomAlbum = nomAlbum;
        this.groupe = groupe;
        this.release = release;
        this.trackList = new ArrayList<>();
    }

    public Album() {
        this.idAlbum = -1; // Default value, can be set later
        this.nomAlbum = "";
        this.trackList = new ArrayList<>();
        this.groupe = defaultGroup;
        this.release = new Date(); // Default to current date
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {this.idAlbum = idAlbum;}

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

    public void setRelease(int day, int month, int year) {
        this.release = new Date(year - 1900, month - 1, day); // Date constructor uses year since 1900 and month from 0 to 11
    }

    public void setNomAlbum(String nomAlbum) {
        this.nomAlbum = nomAlbum;
    }

    public int getYear() {
        return release.getYear() + 1900; // getYear() returns year since 1900
    }

    public int getMonth() {
        return release.getMonth() + 1; // getMonth() returns month from 0 to 11
    }
    public int getDay() {
        return release.getDate(); // getDate() returns day of the month
    }

    public String getReleaseString() {
        return String.format("%02d/%02d/%04d", getDay(), getMonth(), getYear());
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
        morceau.setId(trackList.size() + 1); // Set the ID based on the current size of the trackList
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
        this.setIds();
        return trackList.size();
    }

    public void setIds() {
        if(this.trackList == null) return;
        for(int i = 0; i < trackList.size(); i++) {
            trackList.get(i).setId(i + 1); // Réajuste les IDs des morceaux restants
        }
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
        if (this == obj)return true;
        if (obj == null)return false;
        if (getClass() != obj.getClass())return false;
        Album other = (Album) obj;
        return this.nomAlbum.equals(other.nomAlbum) && this.trackList.equals(other.trackList)&&
                this.groupe.equals(other.groupe) && this.release.equals(other.release);

        //TODO toString()
    }

    @Override
    public String toString() {
        return "Album{" +
                "idAlbum=" + idAlbum +
                ", nomAlbum='" + nomAlbum + '\'' +
                ", trackList=" + trackList +
                ", groupe=" + groupe +
                ", release=" + release +
                '}';
    }
    public Integer getId() {
        return this.idAlbum;
    }
}

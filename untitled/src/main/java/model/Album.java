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

    public void setTrackList(ArrayList<Morceau> trackList) {
        this.trackList.clear();
        this.trackList.addAll(trackList);
    }


    public int addTrack(Morceau morceau) {
        this.trackList.add(morceau);

        return trackList.size();
    }

    public int removeTrack(Morceau morceau) {

        return trackList.size();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

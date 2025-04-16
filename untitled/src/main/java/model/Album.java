package model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;

public class Album
{
    int idAlbum;
    String nomAlbum;
    ArrayList <Morceau> trackList;
    Groupe groupe;
    Date release;



    public Album(int idAlbum, String nomAlbum, ArrayList<Morceau> trackList, Groupe groupe, Date release) {
        this.idAlbum = idAlbum;
        this.nomAlbum = nomAlbum;
        for(Morceau m:trackList){
            this.trackList.add(m);
        }
        this.groupe = groupe;
        this.release = release;
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
        for(Morceau m:trackList){
            this.trackList.add(m);
        }
    }


    public int AddTrack(Morceau morceau){
        this.trackList.add(morceau);

        return trackList.size();
    }

    public int removeTrack(Morceau morceau){

        return trackList.size();
    }


}

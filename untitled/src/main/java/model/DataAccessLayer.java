package model;

import java.util.ArrayList;

public interface DataAccessLayer {
    //Pas besoin de creer des methodes pour les morceaux, on les gère dans l'album(setTracklist, getTracklist, addTrack, removeTrack)

    // Album management methods

    int addAlbum(Album album);
    boolean updateAlbum(Album a);
    boolean deleteAlbum(int id);
    boolean deleteAlbum(Album a);
    Album getAlbumById(int id);
    ArrayList<Album> getCollection();
}

package view;

import model.Album;
import model.Morceau;

import java.util.ArrayList;

public interface ViewCollection {
    
    // Method to display data to the user
    public void displayCollectionAlbums(ArrayList<Album>  Collection);

    public void displayCollectionMorceaux(ArrayList<String>  Collection);

    public Morceau promptForNewMorceau();



    public Integer promptForMorceauId();

    public Integer promptForAlbumId();

    public Album promptForNewAlbum();

    public void showMessage(String message);

}

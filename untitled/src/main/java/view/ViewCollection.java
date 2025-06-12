package view;

import model.Album;
import model.Morceau;
import Controlleur.Controller;

import java.util.ArrayList;

 public interface ViewCollection {
    
    // Method to display data to the user
     void displayCollectionAlbums(ArrayList<Album>  Collection);

     void displayCollectionMorceaux(Album SelectedAlbum);

     Morceau promptForNewMorceau();

    void setController(Controller c);

    void run();


     Integer promptForMorceauId();

     Integer promptForAlbumId();

     Album promptForNewAlbum();


    //si pas le temps de faire exception methode inutiles
     void showMessage(String message);

}

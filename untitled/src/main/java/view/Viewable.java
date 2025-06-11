package view;

import Controlleur.Controller;
import model.Album;
import model.Morceau;

import java.util.ArrayList;


public interface Viewable {

    public void run();

    public void setController(Controller c);

    public void displayCollection(ArrayList<Album>  Collection);

    public void displayCollection(ArrayList<Morceau>  Collection);



}

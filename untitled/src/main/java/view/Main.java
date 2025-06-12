package view;

import Controlleur.Controller;
import model.AlbumDao;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new FenetrePrincipale(), new AlbumDao());

        controller.run();
    }
}

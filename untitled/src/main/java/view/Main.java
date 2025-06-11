package view;

import Controlleur.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controlleur = new Controller(new FenetrePrincipale());

        controlleur.run();
    }
}

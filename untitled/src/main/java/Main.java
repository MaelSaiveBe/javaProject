import com.formdev.flatlaf.FlatDarculaLaf;
import model.AlbumDao;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        // Create an instance of the controller with the main window
        Controlleur.Controller controller = new Controlleur.Controller(new view.FenetrePrincipale(),
                new AlbumDao());

        //set look and feel
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
        // Start the application
        controller.run();
    }
}

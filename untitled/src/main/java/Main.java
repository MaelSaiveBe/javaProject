import com.formdev.flatlaf.FlatDarculaLaf;
import model.DAL.AlbumDao;
import model.DAL.AlbumDaoSerializable;

import javax.swing.*;
import java.io.File;

public class Main {


    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
        // Create an instance of the controller with the main window
        //Controlleur.Controller controller = new Controlleur.Controller(new view.FenetrePrincipale(),
         //       new AlbumDao());
        File file = new File("C:\\Users\\saive\\Desktop\\collection.ser");
        Controlleur.Controller controller = new Controlleur.Controller(new view.FenetrePrincipale(),
                new AlbumDaoSerializable(file));

        //set look and feel

        // Start the application
        controller.run();
    }
}

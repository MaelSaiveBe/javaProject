import model.AlbumDao;

public class Main {


    public static void main(String[] args) {
        // Create an instance of the controller with the main window
        Controlleur.Controller controller = new Controlleur.Controller(new view.FenetrePrincipale(),new AlbumDao());

        // Start the application
        controller.run();
    }
}

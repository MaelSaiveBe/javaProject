package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import model.Album;
import model.Morceau;
import view.Model.AlbumTableModel;

import javax.swing.*;
import java.util.ArrayList;

public class FenetrePrincipale extends JFrame implements ViewCollection {
    private JPanel modelFenetrePrincipale;
    private JTextField nomDUtilisateurTextField;
    private JTable jtAlbums;
    private JButton btnAjoutMorceau;
    private JButton btnAjouterAlbum;
    private JList trackList;
    private JButton btnSupprimerMorceau;
    private JButton btnSupprimerAlbum;

    public FenetrePrincipale(){
        setTitle("Fenetre Principale");
        setContentPane(modelFenetrePrincipale);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        jtAlbumsList();
        pack();
    }
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
        new FenetrePrincipale();
//        Authenticator mapAuthenticator = new MapAuthenticator();
//        boolean isAuthenticatedWithMap = mapAuthenticator.authenticate("utilisateur1", "motdepasse1");
//        System.out.println("authentification via map réussie?" + isAuthenticatedWithMap);

    }

    private void jtAlbumsList() {
        ArrayList<Album> albums = new ArrayList<>();
        jtAlbums.setModel(new AlbumTableModel(albums));
    }

    @Override
    public void displayCollectionAlbums(ArrayList<Album> Collection) {

    }

    @Override
    public void displayCollectionMorceaux(ArrayList<String> Collection) {

    }

    @Override
    public Morceau promptForNewMorceau() {
        JDialogAjoutMorceau JdialogAjoutMorceau = new JDialogAjoutMorceau(this, true);
        JdialogAjoutMorceau.setVisible(true);
        Morceau morceau = JdialogAjoutMorceau.getMorceau();

        return ;
    }

    @Override
    public Morceau promptForUpdateMorceau(String morceau) {
        return ;
    }

    @Override
    public Integer promptForMorceauId() {
        return 0;
    }

    @Override
    public Integer promptForAlbumId() {
        return 0;
    }

    @Override
    public Album promptForNewAlbum() {
        return null;
    }

    @Override
    public Album promptForUpdateAlbum(Album album) {
        return null;
    }

    @Override
    public void showMessage(String message) {

    }
}



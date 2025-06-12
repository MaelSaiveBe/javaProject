package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import model.Album;
import model.Morceau;
import view.Model.AlbumTableModel;
import view.Model.MorceauTableModel;

import javax.swing.*;
import java.util.ArrayList;

public class FenetrePrincipale extends JFrame implements ViewCollection {
    private JPanel modelFenetrePrincipale;
    private JTextField nomDUtilisateurTextField;
    private JTable jtAlbums;
    private JButton btnAjoutMorceau;
    private JButton btnAjouterAlbum;
    private JTable trackList;
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
        JdialogAjoutMorceau.dispose();
        return morceau;
    }


    @Override
    public Integer promptForMorceauId() {
        int index = trackList.getSelectedRow();
        if(index == -1){
            return null;
        }
        return ((MorceauTableModel) trackList.getModel()).getMorceaux(index).getId();
    }

    @Override
    public Integer promptForAlbumId() {
        int index = jtAlbums.getSelectedRow();
        if(index == -1){
            return null;
        }
        return ((AlbumTableModel) jtAlbums.getModel()).getAlbumAt(index).getId();
    }

    @Override
    public Album promptForNewAlbum() {
        JDialogAjouterAlbum dialog = new JDialogAjouterAlbum(this, true);
        dialog.setVisible(true);
        Album album = dialog.getAlbum();
        dialog.dispose();
       return album;
    }



    @Override
    public void showMessage(String message) {

    }
}



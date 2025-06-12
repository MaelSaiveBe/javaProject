package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import model.Album;
import model.Morceau;
import view.Model.AlbumTableColumnModel;
import view.Model.AlbumTableModel;
import view.Model.MorceauTableColoumnModel;
import view.Model.MorceauTableModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
//        setTitle("Fenetre Principale");
//        setContentPane(modelFenetrePrincipale);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        jtAlbumsList();
//        pack();

        super("Fenetre Principale");
        setContentPane(modelFenetrePrincipale);
        setSize(500,500);
        //place la fenetre au centre a l'éxecution(Comportement par défaut fait apparaite dans le
        //                                                                  coin suppérieur gauche)
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //inutile ici car le text était deja hard codé dans le .form
        btnAjoutMorceau.setText(Controlleur.ControllerActions.ADD_MORCEAU);
        btnAjouterAlbum.setText(Controlleur.ControllerActions.ADD_ALBUM);
        btnSupprimerMorceau.setText(Controlleur.ControllerActions.DELETE_MORCEAU);
        btnSupprimerAlbum.setText(Controlleur.ControllerActions.DELETE_ALBUM);

        jtAlbums.setModel(new AlbumTableModel(new ArrayList<>()));
        jtAlbums.setColumnModel(new AlbumTableColumnModel());
        jtAlbums.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
// Relique du passé, ne sert plus à rien
//    private void jtAlbumsList() {
//        ArrayList<Album> albums = new ArrayList<>();
//        jtAlbums.setModel(new AlbumTableModel(albums));
//        jtAlbums.setColumnModel(new AlbumTableColumnModel());
//    }

    public JTable getJtAlbums() {
        return jtAlbums;
    }

    @Override
    public void displayCollectionAlbums(ArrayList<Album> Collection) {
        jtAlbums.setModel(new AlbumTableModel(Collection));
        jtAlbums.setColumnModel(new AlbumTableColumnModel());
    }

    @Override
    public void displayCollectionMorceaux(Album album) {
        trackList.setModel(new MorceauTableModel(album.getTrackList()));
        trackList.setColumnModel(new MorceauTableColoumnModel());

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
        System.out.println(album);
        dialog.dispose();
       return album;
    }



    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message,
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void setController(Controlleur.Controller c) {
        btnAjouterAlbum.addActionListener(c);
        btnAjoutMorceau.addActionListener(c);
        btnSupprimerAlbum.addActionListener(c);
        btnSupprimerMorceau.addActionListener(c);
        jtAlbums.getModel().addTableModelListener(c);
        System.out.println("Ajout du TableModelListener : " + c);

    }

    @Override
    public void run() {
        setVisible(true);
    }

}



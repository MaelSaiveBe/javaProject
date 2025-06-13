package view;

import model.metier.Album;
import model.metier.Morceau;
import view.Model.AlbumTableColumnModel;
import view.Model.AlbumTableModel;
import view.Model.MorceauTableColumnModel;
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
//        setTitle("Fenetre Principale");
//        setContentPane(modelFenetrePrincipale);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        jtAlbumsList();
//        pack();

        super("Fenetre Principale");
        setContentPane(modelFenetrePrincipale);
        setSize(800,500);
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

        trackList.setModel(new MorceauTableModel(new ArrayList<>()));
        trackList.setColumnModel(new MorceauTableColumnModel());
        jtAlbums.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


    }
    public static void main(String[] args){

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
        AlbumTableModel albumTableModel = (AlbumTableModel) jtAlbums.getModel();
        albumTableModel.setAlbums(Collection);

    }

    @Override
    public void displayCollectionMorceaux(Album album) {
        MorceauTableModel model = (MorceauTableModel) trackList.getModel();
        model.setMorceaux(album.getTrackList());
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
        jtAlbums.addMouseListener(c);
        this.addWindowListener(c);
        System.out.println("Ajout du TableModelListener : " + c);

    }

    @Override
    public void run() {
        setVisible(true);
    }

    public void RefreshTracksOnClick(){
        int index = jtAlbums.getSelectedRow();
        if(index != -1) {
            AlbumTableModel model = (AlbumTableModel) jtAlbums.getModel();
            Album album = model.getAlbumAt(index);
            displayCollectionMorceaux(album);
        }else{
            showMessage("Aucun Album Selectionné");
            displayCollectionMorceaux(null);
        }
    }


//    public void RefreshTracksOnClick() {
//        int index = jtAlbums.getSelectedRow();
//        if (index >= 0) {
//            AlbumTableModel model = (AlbumTableModel) jtAlbums.getModel();
//            Album album = model.getAlbumAt(index);
//            if (album != null) {
//                displayCollectionMorceaux(album);
//                trackList.revalidate();
//                trackList.repaint();
//            } else {
//                showMessage("Aucun album sélectionné.");
//            }
//        } else {
//            showMessage("Veuillez sélectionner un album.");
//        }
//    }

}



package Controlleur;

import model.DAL.AlbumDaoSerializable;
import model.metier.Album;
import model.DAL.AlbumDao;
import model.metier.Morceau;
import view.FenetrePrincipale;
import view.Model.AlbumTableModel;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

import static model.serializer.CollectionSerializer.deserialize;
import static model.serializer.CollectionSerializer.serialize;

public final class Controller extends ControllerActions implements ActionListener,
        TableModelListener, MouseListener, WindowListener {
    private final String FILE_NAME = "collection.ser";
    private FenetrePrincipale frame;
    //private AlbumDao dao;
    private AlbumDaoSerializable dao;

    public Controller(FenetrePrincipale frame, AlbumDaoSerializable model) {

        dao = model;
        this.frame = frame;

        //loadData();
        this.frame.setController(this);

    }

    private void loadData() {
        ArrayList<Album> albums = deserialize(FILE_NAME);
        for (Album album : albums) {
            dao.addAlbum(album);
        }
        frame.displayCollectionAlbums(dao.getCollection());
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), ADD_ALBUM)) {
            System.out.println("Action Add Album");
            Album album = frame.promptForNewAlbum();
            System.out.println("Album : " + album);
            if (album != null) {
                dao.addAlbum(album);
                ArrayList<Album> albums = dao.getCollection();
                //test a ma sauce si sa casse c'est ptetre ici-------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //--------/!\/!\/!\/!\-------Spoiler j'ai tout cassé-----/!\/!\/!\/!\-----------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                frame.displayCollectionAlbums(albums);
                // CETTE LIGNE A TOUT CASSÉE
                //frame.setController(this);
                frame.showMessage("Ajout effectué avec succès !");
            }
        }
        if(Objects.equals(e.getActionCommand(), ADD_MORCEAU)) {
            System.out.println("Action Add Morceau");

            Morceau morceau = frame.promptForNewMorceau();
            System.out.println(morceau);
            if (morceau != null) {
                Integer i = frame.promptForAlbumId();
                if(i == null) {
                    frame.showMessage("Aucun album sélectionné !");
                    return;
                }else{
                    Album a= dao.getAlbumById(frame.promptForAlbumId());
                    a.addTrack(morceau);
                    if (!dao.updateAlbum(a)) {
                        frame.showMessage("Erreur lors de l'ajout du morceau à l'album !");
                        return;
                    }
                    frame.displayCollectionAlbums(dao.getCollection());
                    frame.displayCollectionMorceaux(dao.getAlbumById(i));
                    frame.showMessage("Ajout effectué avec succès !");
                }
            }
           else frame.showMessage("Ajout échoué, morceau null !");
        }
        int test;
        if (Objects.equals(e.getActionCommand(), DELETE_MORCEAU)) {
            System.out.println("Action Delete Morceau");
            Integer id = frame.promptForMorceauId();
            System.out.println("ID Morceau : " + id);
            if (id == null) {
                frame.showMessage("Aucun morceau sélectionné !");
            }else {
                int idAlbum = frame.promptForAlbumId();
                System.out.println("ID Album : " + idAlbum);
                if (dao.deleteTrack(idAlbum, id)) {
                    frame.displayCollectionAlbums(dao.getCollection());
                    frame.displayCollectionMorceaux(dao.getAlbumById(idAlbum));
                    frame.showMessage("Suppression effectuée avec succès !");
                } else {
                    frame.showMessage("Erreur de suppression...");
                }
            }
        }

        if(Objects.equals(e.getActionCommand(), DELETE_ALBUM)) {
            System.out.println("Action Delete Album");
            Integer id = frame.promptForAlbumId();
            if (id == null) {
                frame.showMessage("Aucun album sélectionné !");
            } else {
                if (dao.deleteAlbum(id)) {
                    frame.displayCollectionAlbums(dao.getCollection());
                    frame.showMessage("Suppression effectuée avec succès !");
                } else {
                    frame.showMessage("Erreur de suppression...");
                }
            }
        }
    }

    public void run() {
        frame.run();
    }

    public void updateAlbum(Album a) {
        if (dao.updateAlbum(a)) {
            frame.displayCollectionAlbums(dao.getCollection());
            //frame.setController(this);
            frame.showMessage("Modification effectuée avec succès !");
        } else {
            frame.showMessage("Erreur de modification...");
        }
        for (Album alb : dao.getCollection()) {
            System.out.println(alb);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        System.out.println("Table changed: "
        );
        if (e.getType() == TableModelEvent.UPDATE && e.getFirstRow() == e.getLastRow()) {
            int row = e.getFirstRow();
            AlbumTableModel model = (AlbumTableModel) frame.getJtAlbums().getModel();
            Album album = model.getAlbumAt(row);
            updateAlbum(album);
            System.out.println("Album : " + album);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        frame.RefreshTracksOnClick();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.frame.displayCollectionAlbums(dao.getCollection());

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closed");
        serialize(this.dao.getCollection(), FILE_NAME);
        //this.frame.dispose();
        //System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
//        System.out.println("Window closed");
//        serialize(this.dao.getCollection(), FILE_NAME);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

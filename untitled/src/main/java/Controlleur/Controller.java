package Controlleur;

import com.formdev.flatlaf.FlatDarculaLaf;
import model.Album;
import model.AlbumDao;
import model.DataAccessLayer;
import model.Morceau;
import view.FenetrePrincipale;
import view.Model.AlbumTableModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionListener;
import java.util.Objects;

public final class Controller extends ControllerActions implements ActionListener,
        TableModelListener {

    private FenetrePrincipale frame;
    private AlbumDao dao;

    public Controller(FenetrePrincipale frame, AlbumDao model) {
        this.frame = frame;
        dao = model;
        this.frame.setController(this);

    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), ADD_ALBUM)) {
            System.out.println("Action Add Album");
            Album album = frame.promptForNewAlbum();
            System.out.println("Album : " + album);
            if (album != null) {
                dao.addAlbum(album);
                //test a ma sauce si sa casse c'est ptetre ici-------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //--------/!\/!\/!\/!\-------Spoiler j'ai tout cassé-----/!\/!\/!\/!\-----------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                frame.displayCollectionAlbums(dao.getCollection());
                frame.setController(this);
                //frame.showMessage("Ajout effectué avec succès !");
            }
        }
        if(Objects.equals(e.getActionCommand(), ADD_MORCEAU)) {
            System.out.println("Action Add Morceau");

            Morceau morceau = frame.promptForNewMorceau();
            if (morceau != null) {
                dao.getAlbumById(frame.promptForAlbumId()).addTrack(morceau);
                frame.displayCollectionMorceaux(dao.getAlbumById(frame.promptForAlbumId()));
                frame.showMessage("Ajout effectué avec succès !");
            }
           else frame.showMessage("Ajout échoué, morceau null !");


        }

    }

    public void run() {
        frame.run();
    }

    public void updateAlbum(Album a) {
        if (dao.updateAlbum(a)) {
            frame.displayCollectionAlbums(dao.getCollection());
            frame.setController(this);
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
}

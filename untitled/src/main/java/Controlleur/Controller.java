package Controlleur;

import com.formdev.flatlaf.FlatDarculaLaf;
import model.Album;
import model.AlbumDao;
import model.DataAccessLayer;
import model.Morceau;
import view.FenetrePrincipale;

import javax.swing.*;
import java.awt.event.ActionListener;

public final class Controller extends ControllerActions implements ActionListener {

    private FenetrePrincipale frame;
    private AlbumDao dao;

    public Controller(FenetrePrincipale frame, AlbumDao model) {
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
        this.frame = frame;
        dao = model;
        this.frame.setController(this);

    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand() ==  ADD_ALBUM) {
            System.out.println("Action Add Album");
            Album album = frame.promptForNewAlbum();
            if (album != null) {
                dao.addAlbum(album);
                //test a ma sauce si sa casse c'est ptetre ici-------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                //-----------------------------------------------------------------------------------------------------------------------
                frame.displayCollectionAlbums(dao.getCollection());
                frame.showMessage("Ajout effectué avec succès !");
            }
        }
        if(e.getActionCommand() == ADD_MORCEAU) {
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
}

package Controlleur;

import com.formdev.flatlaf.FlatDarculaLaf;
import view.FenetrePrincipale;

import javax.swing.*;
import java.awt.event.ActionListener;

public final class Controller  implements ActionListener {

    private FenetrePrincipale frame;

    public Controller(FenetrePrincipale frame) {
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
    }
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand().equals("Quitter")) {
            System.exit(0);
        }
        if(e.getActionCommand().equals("Ajouter")) {}

    }

    public void run() {
        //frame.run();
    }
}

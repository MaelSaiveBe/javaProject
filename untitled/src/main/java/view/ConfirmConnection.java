package view;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class ConfirmConnection {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
        JOptionPane.showMessageDialog(null,
                "connexion réussie"
        );


    }
}

package view;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreConnexion extends JDialog{
    private JLabel jlUsername;
    private JLabel jlPassword;
    private JTextField tfPassword;
    private JPanel PanelConnection;
    private JTextField tfUsername;
    private JButton btnConnexionValider;
    private JButton btnConnexionClear;

    public FenetreConnexion(JFrame parent, boolean modal){
        setTitle("Fenetre de connexion");
        setContentPane(PanelConnection);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        btnConnexionValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = tfPassword.getText();
                String username = tfUsername.getText();
                System.out.println("username : " + username + " password : " + password);
                dispose();
            }
        });

        btnConnexionClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfPassword.setText("");
                tfUsername.setText("");
            }
        });
  }
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
        new FenetreConnexion(null, true);

    }



}

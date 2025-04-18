package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAjoutChanson extends JDialog{
    private JPanel MainPanel;
    private JLabel titreMorceau;
    private JTextField tfTitreMorceau;
    private JLabel dureeMorceau;
    private JTextField tfDureeMorceau;
    private JButton btnMoreceauValider;
    private JButton btnMorceauAnnuler;

    public JDialogAjoutChanson(JFrame parent, boolean modal) {
//        super(parent, modal);
        setLocationRelativeTo(null);
        setContentPane(MainPanel);
        pack();
        btnMoreceauValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titre = tfTitreMorceau.getText();
                int duree = Integer.parseInt(tfDureeMorceau.getText());
                System.out.println("titre : " + titre + " duree : " + duree);
                dispose();
            }
        });
        btnMorceauAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
        JDialogAjoutChanson dialog = new JDialogAjoutChanson(null, true);
        dialog.setVisible(true);


    }
}

package view;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarculaLaf;
import model.Morceau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogAjoutMorceau extends JDialog{
    private JPanel MainPanel;
    private JLabel titreMorceau;
    private JTextField tfTitreMorceau;
    private JLabel dureeMorceau;
    private JTextField tfDureeMorceau;
    private JButton btnMoreceauValider;
    private JButton btnMorceauAnnuler;

    private Morceau morceauAjouter;

    public JDialogAjoutMorceau(JFrame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
        setContentPane(MainPanel);
        pack();
        btnMoreceauValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titre = tfTitreMorceau.getText();
                int duree = Integer.parseInt(tfDureeMorceau.getText());
                morceauAjouter = new Morceau(titre, duree);
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
        JDialogAjoutMorceau dialog = new JDialogAjoutMorceau(null, true);
        dialog.setVisible(true);


    }

    public Morceau getMorceau() {
        return morceauAjouter;
    }
}

package view;

import model.Album;
import model.Groupe;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JDialogAjouterAlbum extends JDialog {
    private JTextField TBTitreAlbum;
    private JTextField TBNomGroupe;
    private JTextField TBMembres;
    private JSpinner SelectorDateDays;
    private JSpinner SelectorDateMonth;
    private JSpinner SelectorDateYear;
    private JPanel JpanelAjouterAlbum;
    private JButton btnValider;
    private JButton btnAnnuler;

    private Album albumAjouter;

    public JDialogAjouterAlbum(JFrame parent, boolean modal) {

        super(parent,"Ajouter un Album", modal);
        setSize(600, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(JpanelAjouterAlbum);

        SelectorDateDays.setModel(new SpinnerNumberModel(1, 1, 31, 1));
        SelectorDateMonth.setModel(new SpinnerNumberModel(1, 1, 12, 1));
        SelectorDateYear.setModel(new SpinnerNumberModel(2023, 1900, 2100, 1));

        albumAjouter = new Album();


        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String titre = TBTitreAlbum.getText();
                String nomGroupe = TBNomGroupe.getText();
                String membres = TBMembres.getText();
                int day = (Integer) SelectorDateDays.getValue();
                int month = (Integer) SelectorDateMonth.getValue();
                int year = (Integer) SelectorDateYear.getValue();

                ArrayList<String> membresList = new ArrayList<>();
                if (!membres.isEmpty()) {
                    String[] membresArray = membres.split(",");
                    for (String membre : membresArray) {
                        membresList.add(membre.trim());
                    }
                }
                Groupe groupe = new Groupe(nomGroupe, membresList);
                albumAjouter.setNomAlbum(titre);
                albumAjouter.setGroupe(groupe);
                albumAjouter.setRelease(day, month, year);
                dispose();
            }

        });
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                albumAjouter = null;
                dispose();
            }
        });
    }
    public Album getAlbum() {
        return albumAjouter;
    }


}

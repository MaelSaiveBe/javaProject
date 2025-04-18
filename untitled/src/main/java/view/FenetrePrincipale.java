package view;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class FenetrePrincipale extends JFrame {
    private JPanel modelFenetrePrincipale;
    private JTextField nomDUtilisateurTextField;
    private JTable jtAlbums;
    private JButton btnAjoutMorceau;
    private JButton btnAjouterAlbum;
    private JList trackList;
    private JButton btnSupprimerMorceau;
    private JButton btnSupprimerAlbum;

    public FenetrePrincipale(){
        setTitle("Fenetre Principale");
        setContentPane(modelFenetrePrincipale);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        jtAlbumsList();
        pack();
    }
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement du thème FlatLaf");
        }
        new FenetrePrincipale();
//        Authenticator mapAuthenticator = new MapAuthenticator();
//        boolean isAuthenticatedWithMap = mapAuthenticator.authenticate("utilisateur1", "motdepasse1");
//        System.out.println("authentification via map réussie?" + isAuthenticatedWithMap);

    }

    private void jtAlbumsList() {
        jtAlbums.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Groupe", "Titre", "Release"}
        ));
    }
}



package view.Model;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class AlbumTableColumnModel extends DefaultTableColumnModel {
    public AlbumTableColumnModel() {
        super();
        int[] taillesColonnes = {10, 80, 80, 80, 50};
        String[] nomsColonnes = {"Id", "Titre", "Groupe", "Membres", "Date"};

        for (int i = 0; i < taillesColonnes.length; i++) {
            TableColumn c = new TableColumn(i, taillesColonnes[i]);
            c.setHeaderValue(nomsColonnes[i]);
            addColumn(c);
        }
    }
}

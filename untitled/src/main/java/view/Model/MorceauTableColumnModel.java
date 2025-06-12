package view.Model;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class MorceauTableColumnModel extends DefaultTableColumnModel {

    public MorceauTableColumnModel() {
        super();
        int[] taillesColonnes = {10, 100, 50};
        String[] nomsColonnes = {"Id", "Titre", "durée"};

       for (int i = 0; i < taillesColonnes.length; i++) {
           TableColumn c = new TableColumn(i, taillesColonnes[i]);
              c.setHeaderValue(nomsColonnes[i]);
              addColumn(c);
       }
    }


}

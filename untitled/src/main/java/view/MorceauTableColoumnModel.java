package view;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MorceauTableColoumnModel extends DefaultTableModel {

    public MorceauTableColoumnModel() {
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

package view.Model;

import model.Morceau;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MorceauTableModel extends AbstractTableModel {

    private ArrayList<Morceau> morceaux;

    @Override
    public int getRowCount() {
        return morceaux.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // id, titre, duree
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0: return Integer.class; // id
            case 1: return String.class; // titre
            case 2: return String.class; // duree
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Morceau morceau = morceaux.get(rowIndex);
        switch(columnIndex) {
            case 0: return morceau.getId(); // id
            case 1: return morceau.getTitre(); // titre
            case 2: return morceau.dureeToString(); // duree
            default: return null;
        }
    }
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Morceau morceau = morceaux.get(rowIndex);
        switch(columnIndex) {
            case 1: morceau.setTitre((String) value); break; // titre
            case 2:
                int duree;
                String val = (String)value;
                String[] parts = val.split(":");

                morceau.setDuree(Integer.parseInt(parts[0])*60 + Integer.parseInt(parts[1]));
                break; // duree
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1 || columnIndex == 2; // titre and duree are editable
    }

    public Morceau getMorceaux(int rowIndex) {
        return morceaux.get(rowIndex);
    }
}

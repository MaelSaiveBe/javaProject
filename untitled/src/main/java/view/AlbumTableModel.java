package view;

import model.Album;
import model.Groupe;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;


public class AlbumTableModel extends AbstractTableModel {
    private ArrayList<Album> albums;

    public AlbumTableModel(ArrayList<Album> albums) {
        this.albums = albums;
    }

     @Override
    public Class<?> getColumnClass(int c) {
         if (c == 0) return Integer.class; // ID
         if (c == 1) return String.class; // Titre
         if (c == 2) return String.class; // Nom du groupe
         if (c == 3) return String.class; // Date de sortie
         return null;
     }

    @Override
    public int getRowCount() {
        return albums.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // ID, Titre, Nom du groupe, Date de sortie
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Album album = albums.get(rowIndex);
        switch (columnIndex) {
            case 0: return album.getIdAlbum();
            case 1: return album.getNomAlbum();
            case 2: return album.getGroupe();
            case 3: return album.getRelease();
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Album album = albums.get(rowIndex);

       // Assuming value is a String representing the group name
        switch (columnIndex) {
            case 1: album.setNomAlbum((String) value); break;
            case 2:
                Groupe groupe = new Groupe((String) value);
                album.setGroupe(groupe);
                break;
            case 3:
                String dateStr = (String) value;

                ArrayList<String> dateFragment = new ArrayList<>(java.util.Arrays.asList(dateStr.split("/")));
                Date releaseDate = new Date(Integer.parseInt(dateFragment.get(2)), Integer.parseInt(dateFragment.get(1)) - 1, Integer.parseInt(dateFragment.get(0)));
                album.setRelease(releaseDate);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0; // ID is not editable
    }

    public Album getAlbumAt(int index) {
        return albums.get(index);
    }
}

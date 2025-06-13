package model.DAL;

import model.metier.Album;
import model.metier.Morceau;

import java.io.*;
import java.util.ArrayList;

public class AlbumDaoSerializable implements DataAccessLayer {
    private ArrayList<Album> albums;
    private static int LastID = 0;
    private File file;

    public AlbumDaoSerializable(File file) {
        this.file = file;
        if (file.exists()) {
            readData();
            System.out.println("Data loaded from file: " );
        } else {
            albums = new ArrayList<>();
            LastID = 0;
            writeData();
        }

    }

    private void writeData() {
        try {
            FileOutputStream fos = new FileOutputStream(this.file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeInt(LastID);
            oos.writeObject(albums);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture : " +
                    e.getMessage());
        }
    }

    private void readData() {
        try {
            FileInputStream fis = new FileInputStream(this.file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            LastID = ois.readInt();
            albums = (ArrayList<Album>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur Lecture Data : " +
                    e.getMessage()+ e.getCause()+ "//////");
            e.printStackTrace();
            albums = new ArrayList<>();
            LastID = 0;
        }
    }


    @Override
    public int addAlbum(Album album) {
        if (album == null) return -1;
        album.setIdAlbum(++LastID);
        albums.add(album);
        writeData();
        return album.getIdAlbum();
    }

    @Override
    public boolean updateAlbum(Album a) {
        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getIdAlbum() == a.getIdAlbum()) {
                albums.set(i, a);
                writeData();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteAlbum(int id) {
        for (Album a : albums) {
            if (a.getIdAlbum() == id) {
                albums.remove(a);
                writeData();
                return true;
            }
        }
        return false;
    }

    @Override
    public Album getAlbumById(int id) {
        for (Album album : albums) {
            if (album.getIdAlbum() == id) {
                return album;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Album> getCollection() {
        return this.albums;
    }

    @Override
    public boolean deleteTrack(int idAlbum, int idTrack) {
        if(albums.isEmpty()) return false;
        for (Album album : albums) {
            if (album.getIdAlbum() == idAlbum) {
                for(Morceau morceau : album.getTrackList()){
                    if(morceau.getId() == idTrack) {
                        album.getTrackList().remove(morceau);
                        album.setIds();
                        writeData();
                        return true;
                    }
                }
            }
        }return false;
    }
}

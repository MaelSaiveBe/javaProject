package model;

import java.util.ArrayList;

public class AlbumDao implements DataAccessLayer {

    private ArrayList<Album> collection;
    private static int LastId = 0;

    public AlbumDao() {
        collection = new ArrayList<>();
    }

    @Override
    public int addAlbum(Album album) {
        if (album == null) return -1;
        System.out.println(LastId);
        LastId++;
        System.out.println(LastId);
        album.setIdAlbum(LastId);
        System.out.println("id = "+ album.getIdAlbum());
        collection.add(album);
        System.out.println("Albums in collection: " + collection.size());
        for(Album a : collection) {
            System.out.println("Album ID: " + a.getIdAlbum() + ", Name: " + a.getNomAlbum());
        }
        return album.getIdAlbum();
    }

    @Override
    public boolean updateAlbum(Album a) {
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).getIdAlbum() == a.getIdAlbum()) {
                collection.set(i, a);
                return true;
            }
        }
        return false;
    }



    @Override
    public boolean deleteAlbum(int id) {
        for (Album a : collection) {
            if (a.getIdAlbum() == id) {
                collection.remove(a);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteAlbum(Album a) {
        for (Album album : collection) {
            if (album.getIdAlbum() == a.getIdAlbum()) {
                collection.remove(album);
                return true;
            }
        }
        return false;
    }

    @Override
    public Album getAlbumById(int id) {
        for (Album album : collection) {
            if (album.getIdAlbum() == id) {
                return album;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Album> getCollection() {
        //pas secure return collection;
        ArrayList<Album> copy = new ArrayList<>();
        for (Album album : collection) {
            copy.add(new Album(album)); // Assuming Album has a copy constructor
        }
        return copy;
    }
}

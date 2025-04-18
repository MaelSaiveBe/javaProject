package model;

import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<Album> collection = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Album> getCollection() {
        return collection;
    }
    public void setCollection(ArrayList<Album> collection) {
        this.collection.clear();
        this.collection.addAll(collection);
    }

    public int addAlbum(Album album) {
        if (album == null) return -1;

        if(collection.add(album)) return 1;
        else return 0;
    }

    public int removeAlbum(Album album) {
        if (album == null) return -1;
        if(collection.remove(album)) return 1;
        else return 0;
    }


}

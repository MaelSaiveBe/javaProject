package model.serializer;

import model.metier.Album;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionSerializer {

    public static String serialize(ArrayList<Album> collection, String filename) {
        try{
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Album a : collection) {
                oos.writeObject(a);
            }
            oos.flush();

        }
        catch(FileNotFoundException e){
            System.out.println("Le fichier n'existe pas !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture !");
        }
        return filename;
    }

    public static ArrayList<Album> deserialize(String fileName) {
        try{
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Album> collection = new ArrayList<>();
            while (true) {
                try {
                    Album a = (Album) ois.readObject();
                    collection.add(a);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
            return collection;
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas !");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors de la lecture !");
        }
        return new ArrayList<>();
    }
}

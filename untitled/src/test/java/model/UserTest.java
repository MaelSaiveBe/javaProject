package model;

import model.metier.Album;
import model.metier.Groupe;
import model.metier.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUsername() {
        User user = new User("testUser");
        assertEquals("testUser", user.getUsername(), "The username should match the expected value");
    }

    @Test
    void getCollection() {
        Groupe groupe = new Groupe("GroupName", new ArrayList<String>(Arrays.asList("member1", "member2")));
        Date releaseDate = new Date();
        Album album1 = new Album("Album1", groupe, releaseDate);
        Album album2 = new Album("Album2", groupe, releaseDate);

        User user = new User("testUser");
        user.getCollection().add(album1);
        user.getCollection().add(album2);

        assertEquals(2, user.getCollection().size(), "The collection should contain exactly 2 albums");
        assertTrue(user.getCollection().contains(album1), "The collection should include album1");
        assertTrue(user.getCollection().contains(album2), "The collection should include album2");
    }

    @Test
    void setCollection() {
        Groupe groupe = new Groupe("Group1", new ArrayList<>(Arrays.asList("member1", "member2")));
        Date releaseDate = new Date();
        Album album1 = new Album("Album1", groupe, releaseDate);
        Album album2 = new Album("Album2", groupe, releaseDate);

        User user = new User("testUser");

        ArrayList<Album> newCollection = new ArrayList<>();
        System.out.println(newCollection.add(album1));
        System.out.println(newCollection.add(album2));

        user.setCollection(newCollection);

        assertEquals(2, user.getCollection().size());
        assertTrue(user.getCollection().contains(album1));
        assertTrue(user.getCollection().contains(album2));
    }
}
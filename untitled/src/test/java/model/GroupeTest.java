package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {

    private Groupe groupe;
    @BeforeEach
    void setUp() {
        groupe = new Groupe("groupe de test",
                new ArrayList<String>(Arrays.asList("membre 1",  "membre 2", "membre 3")));

    }
    @Test
    void getNom() {
        assertEquals("groupe de test", groupe.getNom());
    }

    @Test
    void setNom() {
        groupe.setNom("test de groupe");
        assertEquals("test de groupe", groupe.getNom());
    }

    @Test
    void getMembres() {
        ArrayList<String> membres = groupe.getMembres();
        assertEquals(Arrays.asList("membre 1", "membre 2", "membre 3"), membres);
    }

    @Test
    void setMembres() {
        groupe.setMembres(new ArrayList<String>(Arrays.asList("membre 4", "membres 5", "membre 6")));
        ArrayList<String> membres = groupe.getMembres();
    assertEquals(Arrays.asList("membre 4", "membres 5", "membre 6"), membres);

    }
}
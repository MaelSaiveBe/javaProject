package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    private ArrayList<String> membres;
    private Groupe PinkFloyd;
    private Date d;
    private ArrayList<Morceau> tracks;
    private ArrayList<Morceau> TestTrue;
    private ArrayList<Morceau> TestFalse;
    Album albumTest;


    @BeforeEach
    void setUp() {
        membres = new ArrayList<>(Arrays.asList("David Gilmour", "Roger Waters", "Nick Mason",
                "Richard Wright"));
        PinkFloyd = new Groupe("Pink Floyd", membres);
        d = new Date(1973, Calendar.MARCH, 1);
        tracks = new ArrayList<Morceau>();

        TestTrue = new ArrayList<Morceau>(Arrays.asList(
                new Morceau("Speak To Me", 67),
                new Morceau("Breathe(In The Air)", 169),
                new Morceau("On The Run", 225),
                new Morceau("Time", 423),
                new Morceau("The Great Gig in The Sky", 284)));

        TestFalse = new ArrayList<Morceau>(Arrays.asList(
                new Morceau("Speak To he", 67),
                new Morceau("Breathe(In The bear)", 169),
                new Morceau("On The pun", 225),
                new Morceau("lime", 423),
                new Morceau("The Great Gig on whisky", 284)));

        albumTest = new Album("Dark Side of The Moon", tracks, PinkFloyd, d);
    }

    @Test
    void setTrackList() {

        albumTest.setTrackList(TestTrue);
        assertEquals(TestTrue, albumTest.getTrackList());

        assertNotEquals(TestFalse, albumTest.getTrackList());
    }

    @Test
    void addTrack() {
        Morceau testTrack = new Morceau("Speak To Me", 67);
        Album albumTestDupe = new Album(albumTest);
        albumTestDupe.addTrack(testTrack);
        assertEquals(albumTestDupe.getTrackList().size(), albumTest.getTrackList().size());
        assertTrue(albumTestDupe.getTrackList().contains(testTrack));


    }

    @Test
    void removeTrack() {
    }

    @Test
    void testEquals() {
    }
}
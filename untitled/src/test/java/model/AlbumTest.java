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
        Morceau testTrack2 = new Morceau("A million miles away", 380);
        Album albumTestDupe = new Album(albumTest);

        assertEquals(1, albumTestDupe.addTrack(testTrack));
        assertTrue(albumTestDupe.getTrackList().contains(testTrack));

        assertEquals(2, albumTestDupe.addTrack(testTrack2));
        assertTrue(albumTestDupe.getTrackList().contains(testTrack));
        assertTrue(albumTestDupe.getTrackList().contains(testTrack2));


    }

    @Test
    void removeTrack() {
        albumTest.setTrackList(TestTrue);
        //test par reference d'objet;
        Morceau time2 = new Morceau("Time", 423);
        albumTest.removeTrack(time2);
        assertFalse(albumTest.getTrackList().contains(time2));
    }

    @Test
    void removeTrackInt(){
        albumTest.setTrackList(TestTrue);
        albumTest.removeTrack(3);
        assertFalse(albumTest.getTrackList().contains(new Morceau("time", 423)));


        ArrayList<Morceau> test = new ArrayList<Morceau>(Arrays.asList(
                new Morceau("Speak To Me", 67),
                new Morceau("Breathe(In The Air)", 169),
                new Morceau("On The Run", 225),
                new Morceau("The Great Gig in The Sky", 284)));
        assertArrayEquals(albumTest.getTrackList().toArray(), test.toArray());

       assertEquals(-2, albumTest.removeTrack(albumTest.getTrackList().size()+1));


//       ArrayList<Morceau> testNull = new ArrayList<Morceau>();
//       assertEquals(-1, albumTest.removeTrack(0));

    }

    @Test
    void testEquals() {
        albumTest.setTrackList(TestTrue);

         ArrayList<String> membres1 = new ArrayList<>(Arrays.asList("David Gilmour", "Roger Waters", "Nick Mason",
                 "Richard Wright"));
         Groupe PinkFloyd1 = new Groupe("Pink Floyd", membres1);
        tracks = new ArrayList<Morceau>();

        Album albumtest2 = new Album("Dark Side of The Moon", tracks, PinkFloyd1, d);
        albumtest2.addTrack(new Morceau("Speak To Me", 67));
        albumtest2.addTrack(new Morceau("Breathe(In The Air)", 169));
        albumtest2.addTrack(new Morceau("On The Run", 225));
        albumtest2.addTrack(new Morceau("Time", 423));
        albumtest2.addTrack(new Morceau("The Great Gig in The Sky", 284));
        assertTrue(albumTest.equals(albumtest2));

    }
}
package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorceauTest {

    private Morceau time;
    private Morceau money;


    @BeforeEach
    public void setUp() {
        time = new Morceau("Time", 413);
        money = new Morceau("money", 383);
        System.out.println("Morceau time: hash " + time.hashCode()+" id " + time.getId());
        System.out.println("Morceau money: hash " + money.hashCode()+" id " + money.getId());

    }
    @Test
    void getId() {
        int id =  money.getId();
        assertEquals(id-1 ,time.getId());
    }

    @Test
    void getTitre() {
        assertEquals("Time", time.getTitre());
        assertEquals("money", money.getTitre());
    }

    @Test
    void setTitre() {
        Morceau test1 = new Morceau("Test1", 20);
        test1.setTitre("TestSucceediHope");
        assertEquals("TestSucceediHope", test1.getTitre());
    }

    @Test
    void getDuree() {
        assertEquals(413, time.getDuree());
        assertEquals(383, money.getDuree());
    }

    @Test
    void setDuree() {
        Morceau test1 = new Morceau("Test1", 95);

        assertEquals("01:35", test1.dureeToString());
        test1.setDuree(100);
        assertEquals("01:40", test1.dureeToString());
        test1.setDuree(120);
        assertEquals("02:00", test1.dureeToString());
    }

    @Test
    void dureeToString() {
        assertEquals("06:53", time.dureeToString());
        assertEquals("06:23", money.dureeToString());
    }

    @Test
    void getMinute() {
        Morceau breathe = new Morceau("breathe", 169);

        assertEquals(2, breathe.getMinute());
        assertEquals(6, money.getMinute());
        assertEquals(6, time.getMinute());

    }

    @Test
    void getSecond() {
        assertEquals(23, money.getSecond());
        assertEquals(53, time.getSecond());
    }

    @Test
    void testEquals() {
    Morceau timeDupe = new Morceau("Time", 413);
    Morceau moneyDupe = new Morceau("money", 383);

        assertTrue(timeDupe.equals(time));
        assertFalse(time.equals(money));
        assertTrue(moneyDupe.equals(money));
        assertFalse(money.equals(time));
    }
}
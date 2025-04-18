package model.authentication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapAuthenticatorTest {
    MapAuthenticator authenticator;
    @BeforeEach
    void setUp() {
        authenticator = new MapAuthenticator();
    }
    @Test
    void isLoginExists() {
        assertTrue(authenticator.isLoginExists("MaelS"));
        assertFalse(authenticator.isLoginExists("yapasCeNomLa"));
    }

    @Test
    void getPassword() {
        assertEquals("azeaze", authenticator.getPassword("MaelS"));
        assertNotEquals("ezaeza", authenticator.getPassword("MaelS"));
    }
}
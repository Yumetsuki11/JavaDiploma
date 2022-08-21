package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void thereIsNoGame() {

        GameStore store = new GameStore();
        Game game = null;

        boolean actual = store.containsGame(game);
        boolean expected = false;
        assertEquals(expected, actual);

    }


    @Test
    public void playerWhoPlayedMoreTest() {
        GameStore store = new GameStore();

        store.addPlayTime("player1", 10);
        store.addPlayTime("player2", 15);
        store.addPlayTime("player3", 3);

        String expected = "player2";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);

    }

    @Test
    public void playingTheSameTimeTest() {
        GameStore store = new GameStore();
        store.addPlayTime("player1", 1);

        String expected = "player1";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void amountOfTimePlayedMoreTest() {
        GameStore store = new GameStore();
        store.addPlayTime("player1", 12);
        store.addPlayTime("player1", 12);
        store.addPlayTime("player2", 22);

        String expected = "player1";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void totalGameTimeTest() {
        GameStore store = new GameStore();

        store.addPlayTime("player1", 10);
        store.addPlayTime("player2", 30);
        store.addPlayTime("player3", 10);

        int expected = 50;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void noPlayersTest() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        String expected = null;
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void fewPlayersPlayedTheMost() {
        GameStore store = new GameStore();
        store.addPlayTime("player1", 10);
        store.addPlayTime("player2", 10);

        String expected = "player1";
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);


    }
}

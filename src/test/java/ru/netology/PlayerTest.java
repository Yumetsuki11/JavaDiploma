package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    /*@Test
    public void shouldInstallNewGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Amogus 2", "Симулятор выживания");

        Player player = new Player("Igoryok");
        player.installGame(game);

        int expected = 0;
        Assertions.assertEquals(expected, 0);
    }*/

    @Test
    public void shouldSumGenreIfNoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 0;
        int actual = player.sumGenre("Приключения");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfSeveralGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Amogus", "Симуляторы выживания");
        Game game2 = store.publishGame("Amogus 2", "Симуляторы выживания");
        Game game3 = store.publishGame("Touhou 28", "Данмаку-шутеры");

        Player player = new Player("Ananaseg2004");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 420);
        player.play(game2, 1337);
        player.play(game3, 1);

        int expected = 1757;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnMostPlayedByGenreIfNoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        Game actual = player.mostPlayerByGenre("Приключения");
        assertNull(actual);
    }

    @Test
    public void shouldReturnMostPlayedByGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Amogus 2", "Симуляторы выживания");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 3);
        player.play(game2, 18);

        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(game1, actual);
    }

    @Test
    public void shouldReturnMostPlayedByGenreIfSeveralGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Umineko no Naku Koro ni", "Визуальные новеллы");
        Game game2 = store.publishGame("Umineko no Naku Koro ni Chiru", "Визуальные новеллы");
        Game game3 = store.publishGame("Ciconia no Naku Koro ni", "Визуальные новеллы");
        Game game4 = store.publishGame("osu!", "Музыкальные");

        Player player = new Player("Ryukishifan1337");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 168);
        player.play(game2, 176);
        player.play(game4, 502);

        Game actual = player.mostPlayerByGenre("Визуальные новеллы");
        assertEquals(game2, actual);
    }
}

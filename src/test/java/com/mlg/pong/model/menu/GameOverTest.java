package com.mlg.pong.model.menu;

import com.mlg.pong.model.menu.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameOverTest {

    private GameOver gameOver;

    @BeforeEach
    void setUp() {
        gameOver = new GameOver("Player1");
    }

    @Test
    void testGetWhoWon() {
        assertEquals("Player1", gameOver.getWhoWon(), "Should return the correct winner");
    }

    @Test
    void testNextEntry() {
        gameOver.nextEntry();
        assertEquals(1, gameOver.getCurrentEntry(), "Next entry should be 1");
    }

    @Test
    void testNextEntryWrapsAround() {
        // Move to the last entry
        gameOver.setCurrentEntry(gameOver.getNumberEntries() - 1);

        // Move to the next entry, should wrap around to the first entry
        gameOver.nextEntry();

        assertEquals(0, gameOver.getCurrentEntry(), "Next entry should wrap around to 0");
    }

    @Test
    void testPreviousEntry() {
        gameOver.previousEntry();
        assertEquals(gameOver.getNumberEntries() - 1, gameOver.getCurrentEntry(), "Previous entry should be last entry");
    }

    @Test
    void testPreviousEntryWrapsAround() {
        // Move to the first entry
        gameOver.setCurrentEntry(0);

        // Move to the previous entry, should wrap around to the last entry
        gameOver.previousEntry();

        assertEquals(gameOver.getNumberEntries() - 1, gameOver.getCurrentEntry(), "Previous entry should wrap around to last entry");
    }

    @Test
    void testGetEntry() {
        String entry = gameOver.getEntry(0);
        assertEquals("Exit", entry, "Should return the correct entry");
    }

    @Test
    void testIsSelected() {
        gameOver.nextEntry();
        assertTrue(gameOver.isSelected(1), "Second entry should be selected");
    }

    @Test
    void testIsSelectedExit() {
        assertTrue(gameOver.isSelectedExit(), "Exit entry should be selected initially");
        gameOver.nextEntry();
        assertFalse(gameOver.isSelectedExit(), "Exit entry should not be selected after moving to the next entry");
    }

    @Test
    void testIsSelectedMenu() {
        assertFalse(gameOver.isSelectedMenu(), "Menu entry should not be selected initially");
        gameOver.nextEntry();
        assertTrue(gameOver.isSelectedMenu(), "Menu entry should be selected");
    }

    @Test
    void testGetNumberEntries() {
        assertEquals(2, gameOver.getNumberEntries(), "Should return the correct number of entries");
    }


}

package com.mlg.pong.model.menu;

import com.mlg.pong.model.menu.DifficultySelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DifficultySelectorTest {

    private DifficultySelector difficultySelector;

    @BeforeEach
    void setUp() {
        difficultySelector = new DifficultySelector();
    }

    @Test
    void testNextEntry() {
        difficultySelector.nextEntry();
        assertEquals(1, difficultySelector.getCurrentEntry(), "Next entry should be 1");
    }

    @Test
    void testNextEntryWrapsAround() {
        // Move to the last entry
        difficultySelector.setCurrentEntry(difficultySelector.getNumberEntries() - 1);

        // Move to the next entry, should wrap around to the first entry
        difficultySelector.nextEntry();

        assertEquals(0, difficultySelector.getCurrentEntry(), "Next entry should wrap around to 0");
    }

    @Test
    void testPreviousEntry() {
        difficultySelector.previousEntry();
        assertEquals(difficultySelector.getNumberEntries() - 1, difficultySelector.getCurrentEntry(), "Previous entry should be last entry");
    }

    @Test
    void testPreviousEntryWrapsAround() {
        // Move to the first entry
        difficultySelector.setCurrentEntry(0);

        // Move to the previous entry, should wrap around to the last entry
        difficultySelector.previousEntry();

        assertEquals(difficultySelector.getNumberEntries() - 1, difficultySelector.getCurrentEntry(), "Previous entry should wrap around to last entry");
    }

    @Test
    void testGetEntry() {
        String entry = difficultySelector.getEntry(0);
        assertEquals("Easy", entry, "Should return the correct entry");
    }

    @Test
    void testIsSelected() {
        assertTrue(difficultySelector.isSelected(0), "First entry should be selected initially");
        difficultySelector.nextEntry();
        assertTrue(difficultySelector.isSelected(1), "Second entry should be selected");
    }

    @Test
    void testGetNumberEntries() {
        assertEquals(3, difficultySelector.getNumberEntries(), "Should return the correct number of entries");
    }


}

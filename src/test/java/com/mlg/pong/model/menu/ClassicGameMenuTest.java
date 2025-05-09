package com.mlg.pong.model.menu;

import com.mlg.pong.model.menu.ClassicGameMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClassicGameMenuTest {
    private ClassicGameMenu classicGameMenu;

    @BeforeEach
    void setUp() {
        classicGameMenu = new ClassicGameMenu();
    }

    @Test
    void testNextEntry() {
        classicGameMenu.nextEntry();
        assertEquals(1, classicGameMenu.getCurrentEntry(), "Next entry should be 1");
    }

    @Test
    void testNextEntryWrapsAround() {
        // Move to the last entry
        classicGameMenu.setCurrentEntry(classicGameMenu.getNumberEntries() - 1);

        // Move to the next entry, should wrap around to the first entry
        classicGameMenu.nextEntry();

        assertEquals(0, classicGameMenu.getCurrentEntry(), "Next entry should wrap around to 0");
    }

    @Test
    void testPreviousEntry() {
        classicGameMenu.previousEntry();
        assertEquals(classicGameMenu.getNumberEntries() - 1, classicGameMenu.getCurrentEntry(), "Previous entry should be last entry");
    }

    @Test
    void testPreviousEntryWrapsAround() {
        // Move to the first entry
        classicGameMenu.setCurrentEntry(0);

        // Move to the previous entry, should wrap around to the last entry
        classicGameMenu.previousEntry();

        assertEquals(classicGameMenu.getNumberEntries() - 1, classicGameMenu.getCurrentEntry(), "Previous entry should wrap around to last entry");
    }

    @Test
    void testGetEntry() {
        String entry = classicGameMenu.getEntry(0);
        assertEquals("Player vs. Player", entry, "Should return the correct entry");
    }

    @Test
    void testIsSelected() {
        assertTrue(classicGameMenu.isSelected(0), "First entry should be selected initially");
        classicGameMenu.nextEntry();
        assertTrue(classicGameMenu.isSelected(1), "Second entry should be selected");
    }

    @Test
    void testGetNumberEntries() {
        assertEquals(3, classicGameMenu.getNumberEntries(), "Should return the correct number of entries");
    }

    @Test
    void testGetCurrentEntry() {
        assertEquals(0, classicGameMenu.getCurrentEntry(), "Should return the current entry");
    }

    @Test
    void testSetCurrentEntry() {
        classicGameMenu.setCurrentEntry(2);
        assertEquals(2, classicGameMenu.getCurrentEntry(), "Should set the current entry");
    }


}

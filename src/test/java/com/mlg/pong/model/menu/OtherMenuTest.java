package com.mlg.pong.model.menu;

import com.mlg.pong.model.menu.OtherMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

public class OtherMenuTest {

    private OtherMenu otherMenu;

    @BeforeEach
    void setUp() {
        otherMenu = new OtherMenu();
    }

    @Test
    void testNextEntry() {
        otherMenu.nextEntry();
        assertEquals(1, otherMenu.getCurrentEntry(), "Next entry should be 1");
    }

    @Test
    void testNextEntryWrapsAround() {
        // Move to the last entry
        otherMenu.setCurrentEntry(otherMenu.getNumberEntries() - 1);

        // Move to the next entry, should wrap around to the first entry
        otherMenu.nextEntry();

        assertEquals(0, otherMenu.getCurrentEntry(), "Next entry should wrap around to 0");
    }

    @Test
    void testPreviousEntry() {
        otherMenu.previousEntry();
        assertEquals(otherMenu.getNumberEntries() - 1, otherMenu.getCurrentEntry(), "Previous entry should be last entry");
    }

    @Test
    void testPreviousEntryWrapsAround() {
        // Move to the first entry
        otherMenu.setCurrentEntry(0);

        // Move to the previous entry, should wrap around to the last entry
        otherMenu.previousEntry();

        assertEquals(otherMenu.getNumberEntries() - 1, otherMenu.getCurrentEntry(), "Previous entry should wrap around to last entry");
    }

    @Test
    void testGetEntry() {
        String entry = otherMenu.getEntry(0);
        assertEquals("Special Game", entry, "Should return the correct entry");
    }

    @Test
    void testIsSelected() {
        otherMenu.nextEntry();
        assertTrue(otherMenu.isSelected(1), "Second entry should be selected");
        assertFalse(otherMenu.isSelected(0), "First entry should not be selected");
        assertFalse(otherMenu.isSelected(2), "Third entry should not be selected");
    }



}

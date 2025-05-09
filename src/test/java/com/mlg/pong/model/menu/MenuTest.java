package com.mlg.pong.model.menu;

import com.mlg.pong.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void testNextEntry() {
        menu.nextEntry();
        assertEquals(1, menu.getCurrentEntry(), "Next entry should be 1");
    }

    @Test
    void testNextEntryWrapsAround() {
        // Move to the last entry
        menu.setCurrentEntry(menu.getNumberEntries() - 1);

        // Move to the next entry, should wrap around to the first entry
        menu.nextEntry();

        assertEquals(0, menu.getCurrentEntry(), "Next entry should wrap around to 0");
    }

    @Test
    void testPreviousEntry() {
        menu.previousEntry();
        assertEquals(menu.getNumberEntries() - 1, menu.getCurrentEntry(), "Previous entry should be last entry");
    }

    @Test
    void testPreviousEntryWrapsAround() {
        // Move to the first entry
        menu.setCurrentEntry(0);

        // Move to the previous entry, should wrap around to the last entry
        menu.previousEntry();

        assertEquals(menu.getNumberEntries() - 1, menu.getCurrentEntry(), "Previous entry should wrap around to last entry");
    }

    @Test
    void testGetEntry() {
        String entry = menu.getEntry(0);
        assertEquals("Classic", entry, "Should return the correct entry");
    }

    @Test
    void testIsSelected() {
        menu.nextEntry();
        assertTrue(menu.isSelected(1), "Second entry should be selected");
        assertFalse(menu.isSelected(2), "Third entry shouldn't be selected");
    }

    @Test
    void testIsSelectedExit() {
        assertFalse(menu.isSelectedExit(), "Exit entry should not be selected initially");
        menu.nextEntry();
        assertFalse(menu.isSelectedExit(), "Exit entry should still not be selected");
        menu.nextEntry(); // Move to the third entry (Exit)
        assertTrue(menu.isSelectedExit(), "Exit entry should be selected");
    }

    @Test
    void testIsSelectedOtherGame() {
        assertFalse(menu.isSelectedOtherGame(), "Other Game entry should not be selected initially");
        menu.nextEntry();
        assertTrue(menu.isSelectedOtherGame(), "Other Game entry should be selected");
    }

    @Test
    void testIsSelectedClassicGame() {
        assertTrue(menu.isSelectedClassicGame(), "Classic Game entry should be selected initially");
        menu.nextEntry();
        assertFalse(menu.isSelectedClassicGame(), "Classic Game entry should not be selected after moving to the next entry");
    }


}

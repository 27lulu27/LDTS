package com.mlg.pong.model;

import com.mlg.pong.model.menu.OtherMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OtherMenuTest {
    private OtherMenu otherMenu;
    @BeforeEach
    public void setUp() {
        otherMenu = new OtherMenu();
    }

    @Test
    public void testNextEntry() {
        // Call the method being tested
        otherMenu.nextEntry();

        // Verify that the currentEntry has been incremented
        assertEquals(1, otherMenu.getCurrentEntry());
    }

    @Test
    public void testPreviousEntry() {
        // Call the method being tested
        otherMenu.previousEntry();

        // Verify that the currentEntry has been decremented
        assertEquals(2, otherMenu.getCurrentEntry());
    }

    @Test
    public void testGetEntry() {
        // Call the method being tested
        String entry = otherMenu.getEntry(1);

        // Verify that the correct entry is returned
        assertEquals("Special Game 2P", entry);
    }

    @Test
    public void testIsSelected() {
        // Set up the currentEntry to be 2
        otherMenu.setCurrentEntry(2);

        // Call the method being tested
        boolean isSelected = otherMenu.isSelected(2);

        // Verify that the correct isSelected value is returned
        assertEquals(true, isSelected);
    }

    @Test
    public void testGetNumberEntries() {
        // Call the method being tested
        int numberEntries = otherMenu.getNumberEntries();

        // Verify that the correct number of entries is returned
        assertEquals(3, numberEntries);
    }
}

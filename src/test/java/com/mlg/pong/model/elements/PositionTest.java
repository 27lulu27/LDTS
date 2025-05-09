package com.mlg.pong.model.elements;

import com.mlg.pong.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(5, 8);
    }

    @Test
    void testDefaultConstructor() {
        Position defaultPosition = new Position();
        assertEquals(10, defaultPosition.getX(), "Default X coordinate should be 10");
        assertEquals(10, defaultPosition.getY(), "Default Y coordinate should be 10");
    }

    @Test
    void testParameterizedConstructorAndGetters() {
        assertEquals(5, position.getX(), "X coordinate should be initialized to 5");
        assertEquals(8, position.getY(), "Y coordinate should be initialized to 8");
    }

    @Test
    void testSetters() {
        position.setX(2);
        position.setY(4);
        assertEquals(2, position.getX(), "X coordinate should be updated to 2");
        assertEquals(4, position.getY(), "Y coordinate should be updated to 4");
    }

    @Test
    void testEquals() {
        Position equalPosition = new Position(5, 8);
        Position differentPosition = new Position(2, 4);

        assertTrue(position.equals(equalPosition), "Positions with the same coordinates should be equal");
        assertFalse(position.equals(differentPosition), "Positions with different coordinates should not be equal");
    }

    @Test
    void testCompareTo() {
        Position smallerPosition = new Position(2, 4);
        Position largerPosition = new Position(8, 12);

        assertTrue(position.compareTo(smallerPosition) > 0, "Position should be greater than smaller position");
        assertTrue(position.compareTo(largerPosition) < 0, "Position should be smaller than larger position");
        assertEquals(0, position.compareTo(position), "Position should be equal to itself");
    }


}

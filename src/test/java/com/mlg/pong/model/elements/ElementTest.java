package com.mlg.pong.model.elements;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElementTest {

    private Element element;

    @BeforeEach
    void setUp() {
        element = new Element(3, 5);
    }

    @Test
    void testConstructorAndGetters() {
        Position position = element.getPosition();
        assertNotNull(position, "Position should not be null");
        assertEquals(3, position.getX(), "X coordinate should be 3");
        assertEquals(5, position.getY(), "Y coordinate should be 5");
    }

    @Test
    void testSetPosition() {
        Position newPosition = new Position(7, 9);
        element.setPosition(newPosition);

        assertEquals(newPosition, element.getPosition(), "Position should be updated");
    }


}

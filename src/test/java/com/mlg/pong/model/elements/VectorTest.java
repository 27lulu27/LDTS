package com.mlg.pong.model.elements;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {

    private Vector vector;

    @BeforeEach
    void setUp() {
        vector = new Vector();
    }

    @Test
    void testDefaultConstructorAndGetters() {
        Position position = vector.getP();
        assertNotNull(position, "Position should not be null");
        assertTrue(position.getX() == 1 || position.getX() == -1, "X coordinate should be 1 or -1");
        assertTrue(position.getY() == 1 || position.getY() == -1, "Y coordinate should be 1 or -1");
    }

    @Test
    void testSetP() {
        Position newPosition = new Position(-1, -1);
        vector.setP(newPosition);
        assertEquals(newPosition, vector.getP(), "Position should be updated");
    }

    @Test
    void testParameterizedConstructor() {
        Position position = new Position(-1, 1);
        Vector newVector = new Vector(position);
        assertEquals(position, newVector.getP(), "Position should be set using the parameterized constructor");
    }


}

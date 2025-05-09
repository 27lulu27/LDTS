package com.mlg.pong.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void testDefaultPositionXY() {
        Position position = new Position();

        assertEquals(10, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    void testSetPositionXY() {
        Position position = new Position(10, 10);
        position.setX(5);
        position.setY(15);

        assertEquals(5, position.getX());
        assertEquals(15, position.getY());
    }

    @Test
    void testCompareEqualPositions() {
        Position position1 = new Position(10, 10);
        Position position2 = new Position(10, 10);

        assertEquals(0, position1.compareTo(position2));
    }

    @Test
    void testEqualPositions() {
        Position position1 = new Position(10, 10);
        Position position2 = new Position(10, 10);

        assertEquals(true, position1.equals(position2));
    }
}

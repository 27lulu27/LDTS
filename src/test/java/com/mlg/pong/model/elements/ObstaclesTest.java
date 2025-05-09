package com.mlg.pong.model.elements;

import com.mlg.pong.model.game.elements.Obstacles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObstaclesTest {

    private Obstacles obstacles;

    @BeforeEach
    void setUp() {
        obstacles = new Obstacles(3, 5, 2);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(3, obstacles.getPosition().getX(), "X coordinate should be 3");
        assertEquals(5, obstacles.getPosition().getY(), "Y coordinate should be 5");
        assertEquals(2, obstacles.getI(), "I should be 2");
    }



}

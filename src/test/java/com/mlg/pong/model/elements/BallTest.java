package com.mlg.pong.model.elements;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BallTest {

    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(5, 8);
    }

    @Test
    void testDefaultConstructorAndGetters() {;
        Ball defaultBall = new Ball(0, 0);
        assertEquals(1, defaultBall.getSpeed(), "Default speed should be 1");
    }

    @Test
    void testParameterizedConstructor() {
        Vector vector = new Vector(new Position(-1, -1));
        int speed = 2;
        Ball newBall = new Ball(2, 4, vector, speed);
        assertEquals(vector.getP(), newBall.getVector().getP(), "Vector should be initialized");
        assertEquals(speed, newBall.getSpeed(), "Speed should be initialized");
    }

    @Test
    void testSetters() {
        Vector vector = new Vector(new Position(-1, -1));
        int speed = 2;

        ball.setVector(vector);
        ball.setSpeed(speed);

        assertEquals(vector.getP(), ball.getVector().getP(), "Vector should be updated");
        assertEquals(speed, ball.getSpeed(), "Speed should be updated");
    }

    @Test
    void testInvertVector() {
        Vector originalVector = ball.getVector();
        Vector invertedVector = ball.invertVector(0);

        assertNotEquals(originalVector.getP(), invertedVector.getP(), "Vector should be inverted");
        assertEquals(originalVector.getP().getX(), invertedVector.getP().getX(), "X coordinate should remain the same");
        assertEquals(-originalVector.getP().getY(), invertedVector.getP().getY(), "Y coordinate should be inverted");
    }

    @Test
    void testStraightVector() {
        ball.setVector(new Vector(new Position(2, 3)));
        Vector straightVector = ball.straightVector();

        assertEquals(0, straightVector.getP().getY(), "Y coordinate should be set to 0 for a straight vector");
    }


}

package com.mlg.pong.model.elements;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(3, 5);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(3, player.getPosition().getX(), "X coordinate should be 3");
        assertEquals(5, player.getPosition().getY(), "Y coordinate should be 5");
        assertEquals(4, player.getSize(), "Size should be 4");
        assertEquals(1, player.getSpeed(), "Speed should be 1");
    }

    @Test
    void testSetSpeed() {
        player.setSpeed(2);
        assertEquals(2, player.getSpeed(), "Speed should be updated");
    }

    @Test
    void testGetPlayersPositions() {
        List<Position> positions = player.getPlayersPositions();
        assertEquals(7, positions.size(), "Should return a list with 7 positions");

        // Check if the positions are correctly calculated
        assertEquals(new Position(3, 5), positions.get(3), "Middle position should be the initial position");
        assertEquals(new Position(3, 6), positions.get(4), "Next position should be below the initial position");
        assertEquals(new Position(3, 7), positions.get(5), "Next position should be two positions below the initial position");
        assertEquals(new Position(3, 4), positions.get(2), "Previous position should be above the initial position");

        // Check if the positions are sorted
        for (int i = 0; i < positions.size() - 1; i++) {
            assertTrue(positions.get(i).compareTo(positions.get(i + 1)) < 0, "Positions should be sorted");
        }
    }

    @Test
    void testGetSection() {
        Position position = new Position(3, 7);
        assertEquals(2, player.getSection(position), "Should return the correct section");
    }

    @Test
    void testSetSize() {
        player.setSize(6);
        assertEquals(6, player.getSize(), "Size should be updated");
    }


}

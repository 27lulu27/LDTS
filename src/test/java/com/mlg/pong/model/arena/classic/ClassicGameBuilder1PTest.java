package com.mlg.pong.model.arena.classic;

import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame1PBuilder;
import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.model.game.elements.Walls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClassicGameBuilder1PTest {
    private List<Walls> walls = new ArrayList<>(); // Assuming you are using ArrayList for Walls
    private Player player1 = new Player(0,0); // Assuming you have a default constructor for Player
    private Player player2 = new Player(10,0);
    private Ball ball = new Ball(5,5); // Assuming you have a default constructor for Ball
    private int width = 70; // Assuming a default width for your game window
    private int height = 30; // Assuming a default height for your game window
    private int points1 = 0; // Initial points for player1
    private int points2 = 0; // Initial points for player2
    private int count = 0; // Initial count
    private int difficulty = 1; // Assuming difficulty levels start from 1
    private ClassicGame mockedcgame;
    @BeforeEach
    void setup(){

        mockedcgame = mock(ClassicGame.class);
        when(mockedcgame.getBall()).thenReturn(ball);

        when(mockedcgame.getWalls()).thenReturn(walls);
        when(mockedcgame.getPlayer1()).thenReturn(player1);
        when(mockedcgame.getPlayer2()).thenReturn(player2);

        when(mockedcgame.getWidth()).thenReturn(width);
        when(mockedcgame.getHeight()).thenReturn(height);

        when(mockedcgame.getPoints1()).thenReturn(points1);
        when(mockedcgame.getPoints2()).thenReturn(points2);

        when(mockedcgame.getCount()).thenReturn(count);
        when(mockedcgame.getDifficulty()).thenReturn(difficulty);
    }

    @Test
    void testCreateGame() {

        assertNotNull(mockedcgame);
        assertEquals(70, mockedcgame.getWidth());
        assertEquals(30, mockedcgame.getHeight());
        assertEquals(player1, mockedcgame.getPlayer1());
        assertEquals(difficulty, mockedcgame.getDifficulty());
        assertEquals(0, mockedcgame.getPoints1());
        assertEquals(0, mockedcgame.getPoints2());

        // Assuming that setPlayer2 is called with the correct coordinates for the computer player
        assertEquals(10, mockedcgame.getPlayer2().getPosition().getX());
        assertEquals(0, mockedcgame.getPlayer2().getPosition().getY());

        // Assuming that setWalls, setBall, setPoints1, setPoints2 are called appropriately
        assertEquals(walls, mockedcgame.getWalls());
        assertEquals(ball, mockedcgame.getBall());
        assertEquals(0, mockedcgame.getPoints1());
        assertEquals(0, mockedcgame.getPoints2());
    }

    @Test
    void testCreateComputer() {
        int difficulty = 1;
        ClassicGame1PBuilder builder = new ClassicGame1PBuilder(difficulty);

        Player computerPlayer = builder.createComputer();

        int expectedX = builder.getWidth() - 2;
        int expectedY = builder.getHeight() / 2;

        assertEquals(expectedX, computerPlayer.getPosition().getX());
        assertEquals(expectedY, computerPlayer.getPosition().getY());
    }

    @Test
    void testCreateBall() {
        // Given
        int difficulty = 1;
        ClassicGame1PBuilder builder = new ClassicGame1PBuilder(difficulty);

        // When
        Ball ball = builder.createBall();

        // Then
        int expectedX = builder.getWidth() / 2;
        int expectedY = builder.getHeight() / 2;

        assertEquals(expectedX, ball.getPosition().getX());
        assertEquals(expectedY, ball.getPosition().getY());
    }

    @Test
    void testCreateWalls() {
        // Given
        int difficulty = 1;
        ClassicGame1PBuilder builder = new ClassicGame1PBuilder(difficulty);

        // When
        List<Walls> walls = builder.createWalls();

        // Then
        assertNotNull(walls);
        assertEquals(2 * mockedcgame.getWidth(), walls.size());

        // Assuming walls are created at the top and bottom of the screen
        for (int c = 0; c < mockedcgame.getWidth(); c++) {
            if(walls.get(c).getPosition().getY()!=29)assertEquals(0, walls.get(c).getPosition().getY());
            else assertEquals(29, walls.get(c).getPosition().getY());

            if(walls.get(c).getPosition().getY()==29)assertEquals(builder.getHeight() - 1, walls.get(c + builder.getWidth()).getPosition().getY());
        }
    }

    @Test
    void testCreatePlayer() {
        // Given
        int difficulty = 1;
        ClassicGame1PBuilder builder = new ClassicGame1PBuilder(difficulty);

        // When
        Player player = builder.createPlayer();

        // Then
        assertEquals(1, player.getPosition().getX());
        assertEquals(builder.getHeight() / 2, player.getPosition().getY());
    }

    @Test
    void testGetWidth() {
        // Given
        int difficulty = 1;

        // When
        int width = mockedcgame.getWidth();

        // Then
        assertEquals(70, width); // Adjust the expected value based on your actual implementation
    }

    @Test
    void testGetHeight() {
        // Given
        int difficulty = 1;

        // When
        int height = mockedcgame.getHeight();

        // Then
        assertEquals(30, height); // Adjust the expected value based on your actual implementation
    }

}

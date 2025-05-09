package com.mlg.pong.controller.elements;

import com.mlg.pong.controller.game.elements.Player1Controller;
import com.mlg.pong.controller.game.elements.Player2Controller;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerControllerTest {
    private SpecialGame game;

    @BeforeEach
    void setUp() {
        game = new SpecialGame(10,10);
        game.setPlayer1(new Player(0,0));
        game.setPlayer2(new Player(0,1));
        List<Walls> walls = new ArrayList<>();
        game.setWalls(walls);
        List<Obstacles> obstacles = new ArrayList<>();
        game.setObstacles(obstacles);
        game.setBall(new Ball(0,0));
        game.setPowerup(new PowerUP(0,0,""));
        game.setDifficulty(0);
    }

    @Test
    public void test_movePlayer1Up() {
        Player player1 = new Player(5, 5);
        game.setPlayer1(player1);
        Player1Controller controller = new Player1Controller(game);

        controller.movePlayerUp();

        assertEquals(4, game.getPlayer1().getPosition().getY());
    }

    @Test
    public void test_movePlayer1Down() {
        Player player1 = new Player(5, 5);
        game.setPlayer1(player1);
        Player1Controller controller = new Player1Controller(game);

        controller.movePlayerDown();

        assertEquals(6, game.getPlayer1().getPosition().getY());
    }

    @Test
    public void test_movePlayer1UpWithWall() {
        Player player1 = new Player(5, 5);
        game.setPlayer1(player1);
        game.getPlayer1().setSize(1);
        game.getWalls().add(new Walls(5,4));
        Player1Controller controller = new Player1Controller(game);

        controller.movePlayerUp();

        assertEquals(5, game.getPlayer1().getPosition().getY());

    }

    @Test
    public void test_movePlayer1DownWithWall() {
        Player player1 = new Player(5, 5);
        game.setPlayer1(player1);
        game.getPlayer1().setSize(1);
        game.getWalls().add(new Walls(5,6));
        Player1Controller controller = new Player1Controller(game);

        controller.movePlayerDown();

        assertEquals(5, game.getPlayer1().getPosition().getY());

    }

    @Test
    public void test_movePlayer2Up() {
        Player player2 = new Player(5, 5);
        game.setPlayer2(player2);
        Player2Controller controller = new Player2Controller(game);

        controller.movePlayerUp();

        assertEquals(4, game.getPlayer2().getPosition().getY());
    }

    @Test
    public void test_movePlayer2Down() {
        Player player2 = new Player(5, 5);
        game.setPlayer2(player2);
        Player2Controller controller = new Player2Controller(game);

        controller.movePlayerDown();

        assertEquals(6, game.getPlayer2().getPosition().getY());
    }

    @Test
    public void test_movePlayer2UpWithWall() {
        Player player2 = new Player(5, 5);
        game.setPlayer2(player2);
        game.getPlayer2().setSize(1);
        game.getWalls().add(new Walls(5,4));
        Player2Controller controller = new Player2Controller(game);

        controller.movePlayerUp();

        assertEquals(5, game.getPlayer2().getPosition().getY());

    }

    @Test
    public void test_movePlayer2DownWithWall() {
        Player player2 = new Player(5, 5);
        game.setPlayer2(player2);
        game.getPlayer2().setSize(1);
        game.getWalls().add(new Walls(5,6));
        Player2Controller controller = new Player2Controller(game);

        controller.movePlayerDown();

        assertEquals(5, game.getPlayer2().getPosition().getY());

    }
}

package com.mlg.pong.controller.elements;

import com.mlg.pong.controller.game.elements.ComputerController;
import com.mlg.pong.controller.game.elements.Player1Controller;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputerControllerTest {
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
        game.setDifficulty(3);
    }

    @Test
    public void test_moveComputer_ballSameHeight() {
        Player computer = new Player(5, 5);
        game.setPlayer2(computer);
        Ball ball = new Ball(5,5,new Vector(new Position(1,0)));
        game.setBall(ball);
        ComputerController controller = new ComputerController(game);

        controller.moveComputer();

        assertEquals(5, game.getPlayer2().getPosition().getY());
    }
    @Test
    public void test_moveComputer_ballUp() {
        Player computer = new Player(5, 5);
        game.setPlayer2(computer);
        Ball ball = new Ball(5,5,new Vector(new Position(1,-1)));
        game.setBall(ball);
        ComputerController controller = new ComputerController(game);

        controller.moveComputer();

        assertEquals(4, game.getPlayer2().getPosition().getY());
    }

    @Test
    public void test_moveComputer_ballDown() {
        Player computer = new Player(5, 5);
        game.setPlayer2(computer);
        Ball ball = new Ball(5,5,new Vector(new Position(1,1)));
        game.setBall(ball);
        ComputerController controller = new ComputerController(game);

        controller.moveComputer();

        assertEquals(6, game.getPlayer2().getPosition().getY());

    }

}

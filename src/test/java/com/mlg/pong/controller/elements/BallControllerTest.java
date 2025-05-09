package com.mlg.pong.controller.elements;

import com.mlg.pong.controller.game.elements.BallController;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame1PBuilder;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.arena.special.SpecialGame1PBuilder;
import com.mlg.pong.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallControllerTest {
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
    public void test_ball_moves_straight_line() {
        Ball ball = new Ball(10, 10,new Vector(new Position(1,0)));
        game.setBall(ball);

        BallController controller = new BallController(game);
        controller.moveBall();

        assertEquals(11, game.getBall().getPosition().getX());
        assertEquals(10, game.getBall().getPosition().getY());
    }

    @Test
    public void test_ball_bounces_off_obstacle() {
        Ball ball = new Ball(10, 5, new Vector(new Position(1, 0)));
        game.getObstacles().add(new Obstacles(11,5,1));
        game.setBall(ball);

        BallController controller = new BallController(game);
        controller.moveBall();
        controller.moveBall();

        assertEquals(9, game.getBall().getPosition().getX());
        assertEquals(5, game.getBall().getPosition().getY());
        assertEquals(-1, game.getBall().getVector().getP().getX());
    }

    @Test
    public void test_ball_bounces_off_wall() {
        Ball ball = new Ball(10, 5, new Vector(new Position(0, 1)));
        game.getWalls().add(new Walls(10,6));
        game.setBall(ball);

        BallController controller = new BallController(game);
        controller.moveBall();
        controller.moveBall();

        assertEquals(10, game.getBall().getPosition().getX());
        assertEquals(4, game.getBall().getPosition().getY());
        assertEquals(-1, game.getBall().getVector().getP().getY());
    }

    @Test
    public void test_ball_bounces_off_player() {
        Ball ball = new Ball(10, 5, new Vector(new Position(-1, 0)));
        game.setPlayer1(new Player(9,5));
        game.setBall(ball);

        BallController controller = new BallController(game);
        controller.moveBall();
        controller.moveBall();

        assertEquals(11, game.getBall().getPosition().getX());
        assertEquals(5, game.getBall().getPosition().getY());
        assertEquals(1, game.getBall().getVector().getP().getX());
    }
    @Test
    public void test_ball_reset(){
        Ball ball = new Ball(0, 5, new Vector(new Position(-1,0 )));
        game.setBall(ball);

        BallController controller = new BallController(game);
        controller.moveBall();

        assertEquals(game.getWidth()/2, game.getBall().getPosition().getX());
        assertEquals(game.getHeight()/2, game.getBall().getPosition().getY());
    }
}

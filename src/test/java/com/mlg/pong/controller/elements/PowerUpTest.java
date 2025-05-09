package com.mlg.pong.controller.elements;

import com.mlg.pong.controller.game.elements.PowerUpController;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PowerUpTest {
    private SpecialGame game;
    @BeforeEach
    void setUp() {
        game = new SpecialGame(40,40);
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
    public void test_powerUp() {
        PowerUP powerup = new PowerUP(5,5,"");
        game.setPowerup(powerup);
        PowerUpController controller = new PowerUpController(game);

        assertFalse(game.getPowerup().isConsumed());
    }

    @Test
    public void test_powerUpConsumption() {
        PowerUP powerup = new PowerUP(5,5,"");
        game.setPowerup(powerup);
        Player player = new Player(5,5);
        game.setPlayer1(player);
        PowerUpController controller = new PowerUpController(game);

        controller.checkPlayerPos();

        assertTrue(game.getPowerup().isConsumed());
    }

    @Test
    public void test_applyEffect_PSIZE() {
        PowerUP powerup = new PowerUP(5,5,"PSIZE");
        game.setPowerup(powerup);
        PowerUpController controller = new PowerUpController(game);

        controller.applyEffects(powerup.getType(), 1);
        controller.applyEffects(powerup.getType(), 2);

        assertEquals(6, game.getPlayer1().getSize());
        assertEquals(6, game.getPlayer2().getSize());
    }

    @Test
    public void test_applyEffect_OSIZE() {
        PowerUP powerup = new PowerUP(5,5,"OSIZE");
        game.setPowerup(powerup);
        PowerUpController controller = new PowerUpController(game);

        controller.applyEffects(powerup.getType(), 1);
        controller.applyEffects(powerup.getType(), 2);

        assertEquals(2, game.getPlayer1().getSize());
        assertEquals(2, game.getPlayer2().getSize());
    }

    @Test
    public void test_RemoveEffect_PSIZE() {
        PowerUP powerup = new PowerUP(5,5,"PSIZE");
        game.setPowerup(powerup);
        PowerUpController controller = new PowerUpController(game);
        game.getPlayer1().setSize(6);
        game.getPlayer2().setSize(6);
        controller.removeEffects(powerup.getType());

        assertEquals(4, game.getPlayer1().getSize());
        assertEquals(4, game.getPlayer2().getSize());
    }

    @Test
    public void test_RemoveEffect_OSIZE() {
        PowerUP powerup = new PowerUP(5,5,"OSIZE");
        game.setPowerup(powerup);
        PowerUpController controller = new PowerUpController(game);
        game.getPlayer1().setSize(2);
        game.getPlayer2().setSize(2);
        controller.removeEffects(powerup.getType());

        assertEquals(4, game.getPlayer1().getSize());
        assertEquals(4, game.getPlayer2().getSize());
    }

    @Test
    public void test_ApplyEffect_WALLS_PLAYER1() {
        PowerUP powerup = new PowerUP(1,10,"WALLS");
        game.setPowerup(powerup);
        PowerUpController controller = new PowerUpController(game);
        controller.applyEffects(powerup.getType(), 1);

        assertFalse(game.getObstacles().isEmpty());
    }

    @Test
    public void test_ApplyEffect_WALLS_PLAYER2() {
        PowerUP powerup = new PowerUP(1,10,"WALLS");
        game.setPowerup(powerup);
        PowerUpController controller = new PowerUpController(game);
        controller.applyEffects(powerup.getType(), 2);

        assertFalse(game.getObstacles().isEmpty());
    }

    @Test
    public void test_RemoveEffect_WALLS() {
        PowerUP powerup = new PowerUP(1,10,"WALLS");
        game.setPowerup(powerup);
        PowerUpController controller = new PowerUpController(game);
        controller.applyEffects(powerup.getType(), 1);
        assertFalse(game.getObstacles().isEmpty());
        controller.removeEffects(powerup.getType());
        assertTrue(game.getObstacles().isEmpty());
    }
}

package com.mlg.pong.controller.game;

import com.mlg.pong.controller.game.classic.ClassicGame1PController;
import com.mlg.pong.controller.game.special.SpecialGame1PController;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpecialGame1PControllerTest {
    private SpecialGame game;
    @BeforeEach
    void setUp() {
        game = new SpecialGame(10,10);
        game.setPlayer1(new Player(1,5));
        game.setPlayer2(new Player(9,5));
        List<Walls> walls = new ArrayList<>();
        game.setWalls(walls);
        List<Obstacles> obstacles = new ArrayList<>();
        game.setObstacles(obstacles);
        game.setBall(new Ball(0,0));
        game.setPowerup(new PowerUP(0,0,""));
        game.setDifficulty(3);
    }
    @Test
    public void test_initialize_controllers() {
        SpecialGame1PController controller = new SpecialGame1PController(game);

        assertNotNull(controller.getPlayer1Controller());
        assertNotNull(controller.getBallController());
        assertNotNull(controller.getPlayer2Controller());
        assertNotNull(controller.getPowerUpController());
    }

    @Test
    public void test_handle_player_movement() throws IOException {
        SpecialGame1PController controller = Mockito.mock(SpecialGame1PController.class);
        controller.step(null, GUI.ACTION.UP, 0);
        Mockito.verify(controller, Mockito.times(1)).step(null, GUI.ACTION.UP, 0);
    }

    @Test
    public void test_handle_ball_movement() throws IOException {
        SpecialGame1PController controller = Mockito.mock(SpecialGame1PController.class);
        controller.step(null, GUI.ACTION.NONE, 0);
        Mockito.verify(controller, Mockito.times(1)).step(null, GUI.ACTION.NONE, 0);
    }
}

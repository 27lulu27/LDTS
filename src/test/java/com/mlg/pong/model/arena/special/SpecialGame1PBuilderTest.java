package com.mlg.pong.model.arena.special;

import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.arena.special.SpecialGame1PBuilder;
import com.mlg.pong.model.game.elements.Ball;
import com.mlg.pong.model.game.elements.Obstacles;
import com.mlg.pong.model.game.elements.Player;
import com.mlg.pong.model.game.elements.PowerUP;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpecialGame1PBuilderTest {

    @Test
    void testCreatePowerUP() {
        // Given
        SpecialGame1PBuilder builder = new SpecialGame1PBuilder(1);

        // When
        PowerUP powerUP = builder.createPowerUP();

        // Then
        assertNotNull(powerUP);
    }

}

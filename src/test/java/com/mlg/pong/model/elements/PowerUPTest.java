package com.mlg.pong.model.elements;

import com.mlg.pong.model.game.elements.PowerUP;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowerUPTest {

    private PowerUP powerUP;

    @BeforeEach
    void setUp() {
        powerUP = new PowerUP(3, 5, "DoublePoints");
    }

    @Test
    void testConstructorAndGetters() {
        assertFalse(powerUP.isConsumed(), "PowerUP should not be consumed initially");
        assertEquals("DoublePoints", powerUP.getType(), "Type should be 'DoublePoints'");
    }

    @Test
    void testConsume() {
        powerUP.Consume();
        assertTrue(powerUP.isConsumed(), "PowerUP should be consumed after calling Consume");
    }


}

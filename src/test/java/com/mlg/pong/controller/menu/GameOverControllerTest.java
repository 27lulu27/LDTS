package com.mlg.pong.controller.menu;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.model.menu.GameOver;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameOverControllerTest {
    @Test
    public void test_create_instance() {
        GameOver menu = new GameOver("");
        GameOverController controller = new GameOverController(menu);
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void test_navigate_up() throws IOException {
        GameOver menu = new GameOver("");
        GameOverController controller = new GameOverController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals((initialEntry - 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down() throws IOException {
        GameOver menu = new GameOver("");
        GameOverController controller = new GameOverController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals((initialEntry + 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_up_at_top() throws IOException {
        GameOver menu = new GameOver("");
        GameOverController controller = new GameOverController(menu);
        menu.setCurrentEntry(0);
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals(menu.getNumberEntries() - 1, menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down_at_bottom() throws IOException {
        GameOver menu = new GameOver("");
        GameOverController controller = new GameOverController(menu);
        menu.setCurrentEntry(menu.getNumberEntries() - 1);
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals(0, menu.getCurrentEntry());
    }
}

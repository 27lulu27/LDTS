package com.mlg.pong.controller.menu;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.menu.DifficultySelector;
import com.mlg.pong.states.classic.DifficultySelectorClassicState;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DifficultySelectorTest {
    @Test
    public void test_create_instance() {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorClassicController controller = new DifficultySelectorClassicController(menu);
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void test_navigate_up() throws IOException {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorClassicController controller = new DifficultySelectorClassicController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals((initialEntry - 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down() throws IOException {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorClassicController controller = new DifficultySelectorClassicController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals((initialEntry + 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_up_at_top() throws IOException {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorClassicController controller = new DifficultySelectorClassicController(menu);
        menu.setCurrentEntry(0);
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals(menu.getNumberEntries() - 1, menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down_at_bottom() throws IOException {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorClassicController controller = new DifficultySelectorClassicController(menu);
        menu.setCurrentEntry(menu.getNumberEntries() - 1);
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals(0, menu.getCurrentEntry());
    }

    @Test
    public void test_create_instance_special() {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorSpecialController controller = new DifficultySelectorSpecialController(menu);
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void test_navigate_up_special() throws IOException {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorSpecialController controller = new DifficultySelectorSpecialController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals((initialEntry - 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down_special() throws IOException {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorSpecialController controller = new DifficultySelectorSpecialController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals((initialEntry + 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_up_at_top_special() throws IOException {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorSpecialController controller = new DifficultySelectorSpecialController(menu);
        menu.setCurrentEntry(0);
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals(menu.getNumberEntries() - 1, menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down_at_bottom_special() throws IOException {
        DifficultySelector menu = new DifficultySelector();
        DifficultySelectorSpecialController controller = new DifficultySelectorSpecialController(menu);
        menu.setCurrentEntry(menu.getNumberEntries() - 1);
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals(0, menu.getCurrentEntry());
    }
}

package com.mlg.pong.controller.menu;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.menu.ClassicGameMenu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClassicGameMenuControllerTest {
    @Test
    public void test_create_instance() {
        ClassicGameMenu menu = new ClassicGameMenu();
        ClassicGameMenuController controller = new ClassicGameMenuController(menu);
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void test_navigate_up() throws IOException {
        ClassicGameMenu menu = new ClassicGameMenu();
        ClassicGameMenuController controller = new ClassicGameMenuController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals((initialEntry - 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down() throws IOException {
        ClassicGameMenu menu = new ClassicGameMenu();
        ClassicGameMenuController controller = new ClassicGameMenuController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals((initialEntry + 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_up_at_top() throws IOException {
        ClassicGameMenu menu = new ClassicGameMenu();
        ClassicGameMenuController controller = new ClassicGameMenuController(menu);
        menu.setCurrentEntry(0);
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals(menu.getNumberEntries() - 1, menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down_at_bottom() throws IOException {
        ClassicGameMenu menu = new ClassicGameMenu();
        ClassicGameMenuController controller = new ClassicGameMenuController(menu);
        menu.setCurrentEntry(menu.getNumberEntries() - 1);
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals(0, menu.getCurrentEntry());
    }
}

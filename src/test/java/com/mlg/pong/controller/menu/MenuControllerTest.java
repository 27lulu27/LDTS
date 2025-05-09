package com.mlg.pong.controller.menu;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.menu.ClassicGameMenu;
import com.mlg.pong.model.menu.Menu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MenuControllerTest {
    @Test
    public void test_create_instance() {
        Menu menu = new Menu();
        MenuController controller = new MenuController(menu);
        assertNotNull(controller);
        assertEquals(menu, controller.getModel());
    }

    @Test
    public void test_navigate_up() throws IOException {
        Menu menu = new Menu();
        MenuController controller = new MenuController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals((initialEntry - 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down() throws IOException {
        Menu menu = new Menu();
        MenuController controller = new MenuController(menu);
        int initialEntry = menu.getCurrentEntry();
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals((initialEntry + 1 + menu.getNumberEntries()) % menu.getNumberEntries(), menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_up_at_top() throws IOException {
        Menu menu = new Menu();
        MenuController controller = new MenuController(menu);
        menu.setCurrentEntry(0);
        controller.step(null, GUI.ACTION.UP, 0);
        assertEquals(menu.getNumberEntries() - 1, menu.getCurrentEntry());
    }

    @Test
    public void test_navigate_down_at_bottom() throws IOException {
        Menu menu = new Menu();
        MenuController controller = new MenuController(menu);
        menu.setCurrentEntry(menu.getNumberEntries() - 1);
        controller.step(null, GUI.ACTION.DOWN, 0);
        assertEquals(0, menu.getCurrentEntry());
    }
}

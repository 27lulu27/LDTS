package com.mlg.pong.viewer;

import com.mlg.pong.gui.GUI;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ViewerTest {
    @Test
    public void test_drawElements() throws IOException, IOException {
        GUI gui = Mockito.mock(GUI.class);
        Viewer<Object> viewer = new Viewer<>(new Object()) {
            @Override
            protected void drawElements(GUI gui) {
                // Assert
                assertNotNull(gui);
            }
        };

        viewer.draw(gui);
        Mockito.verify(gui).clear();
        Mockito.verify(gui).refresh();
    }

    @Test
    public void test_clearGUI() throws IOException {
        GUI gui = Mockito.mock(GUI.class);
        Viewer<Object> viewer = new Viewer<>(new Object()) {
            @Override
            protected void drawElements(GUI gui) {
                // Assert
                Mockito.verify(gui).clear();
            }
        };

        viewer.draw(gui);
        Mockito.verify(gui).refresh();
    }
}



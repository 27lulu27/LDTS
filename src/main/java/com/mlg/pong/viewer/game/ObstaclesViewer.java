package com.mlg.pong.viewer.game;

import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.game.elements.Obstacles;
import com.mlg.pong.model.game.elements.Walls;

public class ObstaclesViewer implements ElementViewer<Obstacles> {
    @Override
    public void draw(Obstacles obstacle, GUI gui) {
        gui.drawObstacles(obstacle.getPosition());
    }
}
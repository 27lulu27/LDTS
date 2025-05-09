package com.mlg.pong.model.game.arena.special;

import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.elements.Obstacles;
import com.mlg.pong.model.game.elements.PowerUP;
import com.mlg.pong.model.game.elements.Walls;

import java.util.List;

public class SpecialGame extends ClassicGame {
    private PowerUP powerup;
    private List<Obstacles> obstacles;


    public PowerUP getPowerup() {
        return powerup;
    }

    public void setPowerup(PowerUP powerup) {
        this.powerup = powerup;
    }

    public List<Obstacles> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<Obstacles> obstacles) {
        this.obstacles = obstacles;
    }
    public int isObstacle(Position position) {
        for (Obstacles obstacle : obstacles)
            if (obstacle.getPosition().equals(position)){
                if (obstacle.getI() == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
            return 2;
    }

    @Override
    public boolean isEmpty(Position position) {
        if(!super.isEmpty(position))return false;
        else{
            for (Obstacles obstacles : obstacles) {
                if (obstacles.getPosition().equals(position)) return false;
            }
        }
        return true;
    }

    public SpecialGame(int width, int height) {
        super(width, height);
    }
}

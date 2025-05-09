package com.mlg.pong.model.game.arena.special;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.classic.ClassicGame1PBuilder;
import com.mlg.pong.model.game.elements.*;
import com.mlg.pong.model.game.elements.Obstacles;
import com.mlg.pong.model.Position;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecialGame1PBuilder extends ClassicGame1PBuilder {

    private int difficulty;

    public SpecialGame1PBuilder(int difficulty) {
        super(difficulty);
        this.difficulty = difficulty;

    }
    public PowerUP createPowerUP(){
        PowerUP powerup = new PowerUP(1,1,"");
        powerup.Consume();
        return powerup;
    }

    private List<Obstacles> createObstacles() {
        List<Obstacles> obstacles = new ArrayList<>();
        Random random = new Random();
        int height = 30;
        int width = 70;

        for (int h = 1; h < height - 1; h += 3) {
            int randomX = random.nextInt(width - 10) + 5;
            int randomSize = random.nextInt(2, 5);
            int randomI = random.nextInt(0, 2);
            if (randomI == 0){
                for (int j = 0; j <= randomSize; j++){
                    obstacles.add(new Obstacles(randomX + j, h, 0));
                }
            }else{
                for (int k = 0; k <= randomSize; k++){
                    obstacles.add(new Obstacles(randomX, h + k, 1));
                }
            }
        }
        return obstacles;
    }
    @Override
    public SpecialGame createGame() {
        SpecialGame cgame = new SpecialGame(getWidth(), getHeight());
        ClassicGame classicGame = super.createGame();
        cgame.setPlayer1(classicGame.getPlayer1());
        cgame.setPlayer2(classicGame.getPlayer2());
        cgame.setWalls(classicGame.getWalls());
        cgame.setObstacles(createObstacles());
        cgame.setBall(classicGame.getBall());
        cgame.setPowerup(createPowerUP());
        cgame.setDifficulty(difficulty);
        return cgame;
    }
}

package com.mlg.pong.controller.game.elements;
import com.mlg.pong.Application;
import com.mlg.pong.controller.Controller;
import com.mlg.pong.gui.GUI;
import com.mlg.pong.model.Position;
import com.mlg.pong.model.game.arena.classic.ClassicGame;
import com.mlg.pong.model.game.arena.special.SpecialGame;
import com.mlg.pong.model.game.elements.Obstacles;
import com.mlg.pong.model.game.elements.PowerUP;
import com.mlg.pong.model.game.elements.Walls;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PowerUpController extends Controller {
    private SpecialGame model = (SpecialGame) getModel();
    private int defaultsize;
    private boolean flag;
    private long last;
    private List<Integer> playerX;
    private List<String> types;
    private List<Obstacles> tempWalls;


    public PowerUpController(SpecialGame sgame) {
        super(sgame);
        this.flag = false;
        this.last = 0;
        this.defaultsize = model.getPlayer1().getSize();
        playerX = new ArrayList<>();
        playerX.add(model.getPlayer1().getPosition().getX());
        playerX.add(model.getPlayer2().getPosition().getX());
        types = new ArrayList<>();
        types.add("PSIZE");
        types.add("OSIZE");
        types.add("WALLS");
        tempWalls = new ArrayList<>();
    }

    public int generateRandX() {
        Random randomX = new Random();
        return playerX.get(randomX.nextInt(0, 2));
    }

    public int generateRandY() {
        Random randomY = new Random();
        while (true) {
            Position pos = new Position(0,randomY.nextInt(5,model.getHeight()-5));
            if (!model.isPlayer(pos)) {return pos.getY();}
        }
    }

    public String generateRandType() {
        Random randomType = new Random();
        return types.get(randomType.nextInt(0,3));
    }

    public void checkPlayerPos() {
        if(model.isPlayer(model.getPowerup().getPosition())) {
            model.getPowerup().Consume();
        }
    }

    public List<Obstacles> getTempWalls() {
        return tempWalls;
    }

    public void applyEffects(String type, int player) {
        if (player == 1) {
            if (type.equals("PSIZE"))
                model.getPlayer1().setSize(defaultsize + 2);
            if (type.equals("OSIZE"))
                model.getPlayer2().setSize(defaultsize - 2);
            if (type.equals("WALLS")) {
                tempWalls = new ArrayList<>();
                for (int i = -3; i <= 3; i++) {
                    tempWalls.add(new Obstacles(15, model.getPowerup().getPosition().getY() + i,1));
                }
                for (Obstacles wall: tempWalls) {
                    model.getObstacles().add(wall);
                }
            }
        }
        if (player == 2) {
            if (type.equals("PSIZE"))
                model.getPlayer2().setSize(defaultsize + 2);
            if (type.equals("OSIZE"))
                model.getPlayer1().setSize(defaultsize - 2);
            if (type.equals("WALLS")) {
                tempWalls = new ArrayList<>();
                for (int i = -3; i <= 3; i++) {
                    tempWalls.add(new Obstacles(model.getWidth() - 15, model.getPowerup().getPosition().getY() + i,1));
                }
                for (Obstacles wall: tempWalls) {
                    model.getObstacles().add(wall);
                }
            }
        }
    }

    public void removeEffects(String type) {
        if (type.equals("PSIZE") || type.equals("OSIZE")) {
            model.getPlayer1().setSize(defaultsize);
            model.getPlayer2().setSize(defaultsize);
        }
        if (type.equals("WALLS")) {
            for (Obstacles wall: tempWalls) {
                model.getObstacles().remove(wall);
            }
        }
    }


    @Override
    public void step(Application app, GUI.ACTION action, long time) throws IOException {
        if (!flag) {
            if (time - last > 12500) {
                model.setPowerup(new PowerUP(generateRandX(), generateRandY(), generateRandType()));
                flag = true;
            }
            if (time - last > 7500) {
                removeEffects(model.getPowerup().getType());
            }
        } else if(model.getPowerup().isConsumed()) {
            last = time;
            flag = false;
            if (model.getPowerup().getPosition().getX() == model.getPlayer1().getPosition().getX()) {
                applyEffects(model.getPowerup().getType(),1);
            }else if (model.getPowerup().getPosition().getX() == model.getPlayer2().getPosition().getX()) {
                applyEffects(model.getPowerup().getType(),2);
            }
        }
        checkPlayerPos();
    }
}

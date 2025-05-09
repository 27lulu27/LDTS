package com.mlg.pong.model.game.elements;

public class Obstacles extends Walls{
    private final int i;

    public Obstacles(int x, int y, int i) {
        super(x, y);
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

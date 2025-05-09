package com.mlg.pong.model.game.elements;

import java.lang.String;

public class PowerUP extends Element{
    private boolean consumed;
    private String type;
    public PowerUP(int x, int y, String type) {super(x,y); consumed = false; this.type = type;}
    public void Consume() {consumed = true;}
    public boolean isConsumed() {return consumed;}
    public String getType() {return type;}
}

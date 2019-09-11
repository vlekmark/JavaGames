package com.mycompany.spelletjes;

public class Field {
    private int number;
    private Player player;

    public Field(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public boolean isSet()  {
        return player != null;
    }

}
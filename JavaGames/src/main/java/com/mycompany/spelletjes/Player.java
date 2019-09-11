package com.mycompany.spelletjes;

public class Player {
    private String name;
    private String symbol;
    private int score;

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
        score = 0;
    }
    public String getSymbol() {
        return symbol;
    }
    public int getScore()   {
        return score;
    }
    public String getName() {
        return name;
    }
    public void Win()   {
        score += 1;
        System.out.println("Congratulations! "+name+" has won "+score+" times!");
    }
}
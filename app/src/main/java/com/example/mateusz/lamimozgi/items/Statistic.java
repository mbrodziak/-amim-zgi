package com.example.mateusz.lamimozgi.items;

public class Statistic {
    private int difficulty;
    private int amountGames;
    private int amountWin;

    public Statistic(int difficulty, int amountGames, int amountWin){
        this.difficulty = difficulty;
        this.amountGames = amountGames;
        this.amountWin = amountWin;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getAmountGames(){
        return amountGames;
    }

    public int getAmountWin(){
        return amountWin;
    }
}

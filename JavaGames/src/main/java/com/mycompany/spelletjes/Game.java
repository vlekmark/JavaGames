package com.mycompany.spelletjes;

public abstract class Game   {
    private Player player1;
    protected Player player2;
    protected Player currentPlayer;
    protected Field[] fields;
    protected int[][] winStates;

    public Game(Player player1, Player player2)  {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        }

	public void play() {
        
        //is game not finished?
        while(!isFinished()) {
        
            //check if player has won
            if(gameIsWon())  {
               currentPlayer.Win();
               break;
            } 
            
            printBoard();
            System.out.println();
            System.out.println("Current player: "+currentPlayer.getName());

            if(!currentPlayer.getName().equals("Computer")) {

                System.out.println("Please select a field");

                int value = App.input.nextInt();
                System.out.println();

                //player selects a field
                boolean result = setField(value);

                if(result)  {
                    //switch current player
                    switchCurrentPlayer();
                }
            }
            if(currentPlayer.getName().equals("Computer")) {

                System.out.println("Computer is selecting a field");
                int value = computerFieldSelection();
                System.out.println();

                //computer selects a field
                boolean result = setField(value);

                if(result)  {
                    //switch current player
                    switchCurrentPlayer();
                }
            }
        }
    }

    private void switchCurrentPlayer()  {
        if(currentPlayer == player1)   {
            currentPlayer = player2;
        } else  {
            currentPlayer = player1;
        }
    }
    protected abstract void printBoard();
    
    protected abstract boolean setField(int fieldNumber);
    
    protected abstract int computerFieldSelection();

    protected abstract boolean isFinished();

    protected abstract boolean gameIsWon();

    protected abstract boolean evaluateWinState(int[] winState);
}
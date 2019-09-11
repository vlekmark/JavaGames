package com.mycompany.spelletjes;

import java.util.Random;

public class TicTacToe extends Game {

    public TicTacToe(Player player1, Player player2)  {
        super(player1, player2);
        fields = new Field[9];
        winStates = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9},
    
            {1,4,7},
            {2,5,8},
            {3,6,9},
    
            {1,5,9},
            {3,5,7}
    
        };

        for(int i = 0; i<9; i++)    {
            fields[i] = new Field(i + 1);
        }
    }

    @Override
    protected void printBoard()   {
        for(int i=0; i<3; i++)   {
            for(int j = 0; j<3; j++) {
                //is field set?
                if(fields[i * 3 + j].isSet())    {
                    //yes:print player symbol
                    String symbol = fields[i * 3 + j].getPlayer().getSymbol();
                    System.out.print("| "+symbol+" |");
                } else{
                //no:print field number
                int number = fields[i * 3 + j].getNumber();
                System.out.print("| "+number+" |");
                }
            }
        System.out.println();
        }
    }

    @Override
    protected boolean setField(int fieldNumber) {
        boolean result = false;

        //check for valid input
        if(fieldNumber > 0 && fieldNumber < 10) {

            //check if field is set
            if(!fields[fieldNumber - 1].isSet()) {
                fields[fieldNumber - 1].setPlayer(currentPlayer);
                result = true;
            }
        }
        return result;
    }  
    
    @Override
    protected int computerFieldSelection() {

        //row 1 horizontal check enemy fields
        if( fields[2].isSet() && fields[2].getPlayer() != player2 && 
            fields[3].isSet() && fields[3].getPlayer() != player2 &&
            !fields[1].isSet()    ) {
            int value = 1;
            return value;
        }
        else if(fields[1].isSet() && fields[1].getPlayer() != player2 && 
                fields[3].isSet() && fields[3].getPlayer() != player2 &&
                !fields[2].isSet()    ) {
            int value = 2;
            return value;
        }
        else if(fields[1].isSet() && fields[1].getPlayer() != player2 && 
                fields[2].isSet() && fields[2].getPlayer() != player2 &&
                !fields[3].isSet()    ) {
            int value = 3;
            return value;
        }
        
        //row 2 horizontal check enemy fields
        else if(fields[5].isSet() && fields[5].getPlayer() != player2 && 
                fields[6].isSet() && fields[6].getPlayer() != player2 &&
                !fields[4].isSet()    ) {
            int value = 4;
            return value;
        }
        else if(fields[4].isSet() && fields[4].getPlayer() != player2 && 
                fields[6].isSet() && fields[6].getPlayer() != player2 &&
                !fields[5].isSet()    ) {
            int value = 5;
            return value;
        }
        else if(fields[4].isSet() && fields[4].getPlayer() != player2 && 
                fields[5].isSet() && fields[5].getPlayer() != player2 &&
                !fields[6].isSet()    ) {
            int value = 6;
            return value;
        }
        
        //row 3 horizontal check enemy fields
        else if(fields[8].isSet() && fields[8].getPlayer() != player2 && 
                fields[9].isSet() && fields[9].getPlayer() != player2 &&
                !fields[7].isSet()    ) {
            int value = 7;
            return value;
        }
        else if(fields[7].isSet() && fields[7].getPlayer() != player2 && 
                fields[9].isSet() && fields[9].getPlayer() != player2 &&
                !fields[8].isSet()    ) {
            int value = 8;
            return value;
        }
        else if(fields[7].isSet() && fields[7].getPlayer() != player2 && 
                fields[8].isSet() && fields[8].getPlayer() != player2 &&
                !fields[9].isSet()    ) {
            int value = 9;
            return value;
        }
        
        //collumn A vertical check enemy fields
        else if(fields[4].isSet() && fields[4].getPlayer() != player2 && 
                fields[7].isSet() && fields[7].getPlayer() != player2 &&
                !fields[1].isSet()    ) {
            int value = 1;
            return value;
        }
        else if(fields[1].isSet() && fields[1].getPlayer() != player2 && 
                fields[7].isSet() && fields[7].getPlayer() != player2 &&
                !fields[4].isSet()    ) {
            int value = 4;
            return value;
        }
        else if(fields[1].isSet() && fields[1].getPlayer() != player2 && 
                fields[4].isSet() && fields[4].getPlayer() != player2 &&
                !fields[7].isSet()    ) {
            int value = 7;
            return value;
        }
       
        //collumn B vertical check enemy fields
        else if(fields[5].isSet() && fields[5].getPlayer() != player2 && 
                fields[8].isSet() && fields[8].getPlayer() != player2 &&
                !fields[2].isSet()    ) {
            int value = 2;
            return value;
        }
        else if(fields[2].isSet() && fields[2].getPlayer() != player2 && 
                fields[8].isSet() && fields[8].getPlayer() != player2 &&
                !fields[5].isSet()    ) {
            int value = 5;
            return value;
        }
        else if(fields[2].isSet() && fields[2].getPlayer() != player2 && 
                fields[5].isSet() && fields[5].getPlayer() != player2 &&
                !fields[8].isSet()    ) {
            int value = 8;
            return value;
        }
         
        //collumn C vertical check enemy fields
        else if(fields[6].isSet() && fields[6].getPlayer() != player2 && 
                fields[9].isSet() && fields[9].getPlayer() != player2 &&
                !fields[3].isSet()    ) {
            int value = 3;
            return value;
        }
        else if(fields[3].isSet() && fields[3].getPlayer() != player2 && 
                fields[9].isSet() && fields[9].getPlayer() != player2 &&
                !fields[6].isSet()    ) {
            int value = 6;
            return value;
        }
        else if(fields[3].isSet() && fields[3].getPlayer() != player2 && 
                fields[6].isSet() && fields[6].getPlayer() != player2 &&
                !fields[9].isSet()    ) {
            int value = 9;
            return value;
        }
        
        //1,5,9 diagonal check enemy fields
        else if(fields[5].isSet() && fields[5].getPlayer() != player2 && 
                fields[9].isSet() && fields[9].getPlayer() != player2 &&
                !fields[1].isSet()    ) {
            int value = 1;
            return value;
        }
        else if(fields[1].isSet() && fields[1].getPlayer() != player2 && 
                fields[9].isSet() && fields[9].getPlayer() != player2 &&
                !fields[5].isSet()    ) {
            int value = 5;
            return value;
        }
        else if(fields[1].isSet() && fields[1].getPlayer() != player2 && 
                fields[5].isSet() && fields[5].getPlayer() != player2 &&
                !fields[9].isSet()    ) {
            int value = 9;
            return value;
        }
        
        //3,5,7 diagonal check enemy fields
        else if(fields[5].isSet() && fields[5].getPlayer() != player2 && 
                fields[7].isSet() && fields[7].getPlayer() != player2 &&
                !fields[3].isSet()    ) {
            int value = 3;
            return value;
        }
        else if(fields[3].isSet() && fields[3].getPlayer() != player2 && 
                fields[7].isSet() && fields[7].getPlayer() != player2 &&
                !fields[5].isSet()    ) {
            int value = 5;
            return value;
        }
        else if(fields[3].isSet() && fields[3].getPlayer() != player2 && 
                fields[5].isSet() && fields[5].getPlayer() != player2 &&
                !fields[7].isSet()    ) {
            int value = 7;
            return value;
        }
        
        else {
            Random r = new Random();
            int rCheck = r.nextInt(9) + 1;
            
            if(fields[rCheck].isSet()) {
                return 0;
            } 
            else {
                int value = rCheck;
                return value;
            }
        }
    }

    @Override
    protected boolean gameIsWon() {
        boolean gameWon = false;
        for (int[] winState : winStates)    {
            if(evaluateWinState(winState))  {
                gameWon = true;
                break;
            }
        }
        return gameWon;
    }

    @Override
    protected boolean isFinished()    {
        boolean finished = true;
        //for(i : iets) -> for each loop, loopt een array door
        for(Field field : fields)   {
            if(!field.isSet())  {
                finished = false;
                break;
            }
        }
        return finished;
    }

    @Override
    protected boolean evaluateWinState(int[] winState)    {
        boolean found = true;
        for(int field : winState)   {
            if(fields[field-1].getPlayer() != currentPlayer)    {
                found = false;
                break;
            }
        }
        return found;
    }

}
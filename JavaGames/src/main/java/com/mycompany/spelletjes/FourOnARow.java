package com.mycompany.spelletjes;

public class FourOnARow extends Game   {

    public FourOnARow(Player player1, Player player2)  {
        super(player1, player2);
        fields = new Field[42];

        for(int i = 0; i<42; i++)    {
            fields[i] = new Field(i + 1);
        }
    }

    @Override
    protected void printBoard()   {
        for(int i=0; i<6; i++)   {
            for(int j = 0; j<7; j++) {
                //is field set?
                if(fields[i * 7 + j].isSet())    {
                    //yes:print player symbol
                    String symbol = fields[i * 7 + j].getPlayer().getSymbol();
                    System.out.print(symbol+" ");
                } else{
                //no:print *
                System.out.print("* ");
                }
            }
        System.out.println();
        }
    //Line numbers for easy selection
    System.out.println("1 2 3 4 5 6 7");
    }

    @Override
    protected boolean setField(int columnNumber) {
        boolean result = false;

        //check for valid input
        if(columnNumber > 0 && columnNumber < 8) {

            for (int i = 5; i >= 0; i--)    {
            //check if field is set
                if(!fields[i*7 + columnNumber - 1].isSet()) {
                    fields[i*7 + columnNumber - 1].setPlayer(currentPlayer);
                    int lastSetFieldNumber = i*7 + columnNumber - 1;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    protected boolean gameIsWon() {
        boolean result = false;
        //result = evaluateFieldsDown();
        //result |= evaluateFieldsLeft();
        //result |= evaluateFieldsRight();
        return result;
    }
    /*
    protected boolean evaluateFieldsRight(lastSetFieldNumber)   {
        boolean result = false;
        if(lastSetFieldNumber % 7 < 3) {
            for(int i = 0; i <= 3; i++)   {
                if(currentPlayer == fields[lastSetFieldNumber + i].getPlayer())    {
                    if(i == 3)  {
                    result = true;
                    }
                } else  {
                    break;
                }
            }
        }
        return result;
    }
    protected boolean evaluateFieldsLeft()   {
        if(lastSetFieldNumber % 7 > 3) {

        }
    }
    protected boolean evaluateFieldsDown()   {
        if(lastSetFieldNumber / 7 < 3) {

        }
    }
*/
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
        for(int fieldIndex : winState)   {
            Field currentField = fields[fieldIndex-1];
            if(currentField.getPlayer() != currentPlayer)    {
                found = false;
                break;
            }
        }
        return found;
    }

    @Override
    protected int computerFieldSelection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
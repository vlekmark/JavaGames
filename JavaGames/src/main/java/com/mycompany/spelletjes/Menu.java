package com.mycompany.spelletjes;

public final class Menu {
    
    private Player player1;
    private Player player2;
    
    public Menu() {
    
    System.out.println();
    System.out.println("*------------------------------------------------------------*");
    System.out.println("| Welcome! This is an app for playing different board games! |");
    System.out.println("*------------------------------------------------------------*");
    System.out.println();
    
    System.out.println("Player 1, what is your name?");
    String name = App.input.nextLine();  
    Player player = new Player(name,"X");
    this.player1 = player;
    System.out.println();

    playerSelect();
    System.out.println();
 
    gameSelect(player1, player2);
    }
    
    protected void playerSelect() {
        
        System.out.println("Who do you want to play against?");
        System.out.println("1: Another Person?");
        System.out.println("2: Or Computer?");
        
        String playerOrComputer = App.input.next();
        
        if(playerOrComputer.equals("1")) {
            System.out.println("Player 2, what is your name?");
            String name = App.input.nextLine();  
            Player player = new Player(name,"O");
            this.player2 = player;
        }
        if(playerOrComputer.equals("2")) {
            String name = "Computer"; 
            Player player = new Player(name,"O");
            this.player2 = player;
        }
    }
    
    protected void gameSelect(Player player1, Player player2) {
        
        System.out.println("What game do you want to play?");
        System.out.println("1: TicTacToe?");
        System.out.println("2: Or FourOnARow? (Computer is a W.I.P.)");
        
        String select = App.input.next();
        System.out.println();
        
        while(select.equals("2"))   {
            FourOnARow game = new FourOnARow(player1, player2);
                game.play();
                    
                System.out.println("New game?(Y/N)");
                String n = App.input.next();
            
                if(n.toUpperCase().equals("Y"))    {
                    select = "2";
                }
                else { 
                    break;
                }
            }

        while(select.equals("1")) {
            TicTacToe game = new TicTacToe(player1, player2);
                game.play();
                    
                System.out.println("New game?(Y/N)");
                String n = App.input.next();
            
                if(n.toUpperCase().equals("Y"))    {
                    select = "1";
                }
                else {
                    break;
                }
        }
    }
}
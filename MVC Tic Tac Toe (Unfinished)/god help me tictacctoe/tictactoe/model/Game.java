package tictactoe.model;

import tictactoe.model.Field.Symbol;

public class Game {
    private Board board;
    
    private int turnsCounter; 
    private Symbol userSymbol; 
    private boolean didSomeoneWin; 
    

    public Game() {
        board = new Board();
        
        turnsCounter = 0;
        userSymbol = Symbol.NONE;
        didSomeoneWin = false;
    }

    public void setFieldOwner(Symbol userSymbol, int x, int y) {
        board.setFieldOwner(userSymbol, x, y);
    }

 
    public Symbol getFieldOwner(int x, int y) {
        return board.getFieldOwner(x, y);
    }

    

    public boolean isGameOver() {
        int[] scores = board.evaluateBoard();
        
        for (int score : scores) {
            if (score == 3 || score == -3) {
                didSomeoneWin = true;
                return true;
            }
        }
        
        if (turnsCounter == 14) return true; else return false;
    }
    

    public void incrementTurnsCounter() {
        turnsCounter++;
    }
    

    public int getTurnsCounter() {
        return turnsCounter;
    }
    
   
    public void setUserSymbol() {
        if (turnsCounter % 2 == 1) userSymbol = Symbol.X; else userSymbol = Symbol.O;
    }
    
 
    public Symbol getUserSymbol() {
        return userSymbol;
    }
    
  
    public boolean getDidSomeoneWin() {
        return didSomeoneWin;
    }

 
    public void incTurnCounterAndSetUserSymbol() {
        incrementTurnsCounter();
        setUserSymbol();
    }
}
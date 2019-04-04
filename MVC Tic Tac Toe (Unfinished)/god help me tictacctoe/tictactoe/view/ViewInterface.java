package tictactoe.view;

import tictactoe.model.Field.Symbol;

import javax.swing.JButton;

public interface ViewInterface
{

    public void updateBoard(Symbol owner, JButton button);
    

    public void informWin(Symbol userSymbol);
    
    
    public void informTie();
}

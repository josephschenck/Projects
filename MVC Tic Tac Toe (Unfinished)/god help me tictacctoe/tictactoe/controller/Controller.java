package tictactoe.controller;

import tictactoe.model.Game;
import tictactoe.utils.Pair;
import tictactoe.view.View;
import tictactoe.view.ViewInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Controller implements ActionListener {
    private Game game;
    private ViewInterface view;


    public Controller() {
        this.game = new Game();
        this.view = new View();
        addActionListeners();
    }


    private void addActionListeners() {
        for (int i = 0; i < ((View)view).getNumberOfButtons(); i++) {
            ((View)view).getButton(i).addActionListener(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (!game.isGameOver()) {
            game.incTurnCounterAndSetUserSymbol();

            
            int indexOfViewButton = getJButtonIndex((JButton) e.getSource());

            Pair coordinates = convertToCoordinates(indexOfViewButton);
            game.setFieldOwner(game.getUserSymbol(),
                               coordinates.first,
                               coordinates.second);

            view.updateBoard(game.getUserSymbol(), (JButton) e.getSource());
        }
    }


    private int getJButtonIndex(JButton button) {
        int buttonIndex = 0;
        for (int i = 0; i < 12; i++) {
            if (button == ((View)view).getButton(i)) {
                buttonIndex = i;
            }
        }
        return buttonIndex;
    }


    private Pair convertToCoordinates(int index) {
        int first = 0, second = 0; // forced initialization

        switch (index) {
            case 0: first = 0; second = 0; break;
            case 1: first = 0; second = 1; break;
            case 2: first = 0; second = 2; break;
            case 3: first = 1; second = 0; break;
            case 4: first = 1; second = 1; break;
            case 5: first = 1; second = 2; break;
            case 6: first = 2; second = 0; break;
            case 7: first = 2; second = 1; break;
            case 8: first = 2; second = 2; break;
        }

        return Pair.create(first, second);
    }

    public void informOutcome() {
        if (game.getDidSomeoneWin()) {
            view.informWin(game.getUserSymbol());
        } else {
            view.informTie();
        }
    }

    public boolean isGameOver() {
        return game.isGameOver();
    }
}
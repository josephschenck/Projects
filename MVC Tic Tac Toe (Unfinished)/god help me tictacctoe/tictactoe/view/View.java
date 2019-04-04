package tictactoe.view;

import tictactoe.model.Field.Symbol;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View extends JFrame implements ViewInterface {
    private final GridLayout grid;     
    private final JButton[] buttons;   
    public View() {
        super("tic-tac-toe");
        grid = new GridLayout(4, 4);
        buttons = new JButton[16];

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
        setVisible(true);

        getRootPane().setDefaultButton(buttons[4]);
        buttons[4].requestFocus();
    }

  
    public void addComponentsToPane(final Container pane) {
        final JPanel panel = new JPanel();
        panel.setLayout(grid);        
        panel.setPreferredSize(new Dimension(300, 300));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].getPreferredSize();
            panel.add(buttons[i]);
        }

        pane.add(panel);
    }

    @Override

    public void updateBoard(Symbol userSymbol, JButton button) {
        try {
            Image icon = ImageIO.read(View.class.getResource("icons/" + userSymbol.toString() + ".png"));
            button.setIcon(new ImageIcon(icon));
            button.setEnabled(false);
        } catch (IOException ex) {
            System.out.println("icons/" + userSymbol.toString() + ".png not found.");
        }
    }


    @Override
    public void informWin(Symbol userSymbol) {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }

        JOptionPane.showMessageDialog(null, "Player " + userSymbol.toString() + " has won!");
    }

    @Override
    public void informTie() {
        JOptionPane.showMessageDialog(null, "Tie!");
    }


    public JButton getButton(int index) {
        return buttons[index];
    }


    public int getNumberOfButtons() {
        return buttons.length;
    }
}
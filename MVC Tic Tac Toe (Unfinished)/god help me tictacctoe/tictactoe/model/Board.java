package tictactoe.model;

import tictactoe.model.Field.Symbol;

public class Board {
    private Field[][] gameGrid;
    private static final int BOARD_SIDE_LENGTH = 4;
    
    public Board() {
        gameGrid = new Field[BOARD_SIDE_LENGTH][BOARD_SIDE_LENGTH];
        
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            for (int j = 0; j < BOARD_SIDE_LENGTH; j++) {
                gameGrid[i][j] = Field.getDefault();
            }
        }
    }
    

    public int[] evaluateBoard() {
        int[] scores = new int[8];

        // evaluate the first row
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[0][i].getOwner() == Symbol.X) scores[0]++;
            if (gameGrid[0][i].getOwner() == Symbol.O) scores[0]--;
        }

        // evaluate the second row
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[1][i].getOwner() == Symbol.X) scores[1]++;
            if (gameGrid[1][i].getOwner() == Symbol.O) scores[1]--;
        }

        // evaluate the third row
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[2][i].getOwner() == Symbol.X) scores[2]++;
            if (gameGrid[2][i].getOwner() == Symbol.O) scores[2]--;
        }

        // evaluate the first column
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[i][0].getOwner() == Symbol.X) scores[3]++;
            if (gameGrid[i][0].getOwner() == Symbol.O) scores[3]--;
        }

        // evaluate the second column
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[i][1].getOwner() == Symbol.X) scores[4]++;
            if (gameGrid[i][1].getOwner() == Symbol.O) scores[4]--;
        }

        // evaluate the third column
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[i][2].getOwner() == Symbol.X) scores[5]++;
            if (gameGrid[i][2].getOwner() == Symbol.O) scores[5]--;
        }

        // evaluate the left-to-right diagonal
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[i][i].getOwner() == Symbol.X) scores[6]++;
            if (gameGrid[i][i].getOwner() == Symbol.O) scores[6]--;
        }

        // evaluate the right-to-left diagonal
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) { // rows
            for (int j = 0; j < BOARD_SIDE_LENGTH; j++) { // columns
                if (i + j == 3) { // right diagonal contain x's and y's that add up to 2
                    if (gameGrid[i][j].getOwner() == Symbol.X) scores[7]++;
                    if (gameGrid[i][j].getOwner() == Symbol.O) scores[7]--;
                }
            }
        }
        
        // evaluate the fourth row row
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[3][i].getOwner() == Symbol.X) scores[6]++;
            if (gameGrid[3][i].getOwner() == Symbol.O) scores[6]--;
        }
        
               // evaluate the third column
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            if (gameGrid[i][3].getOwner() == Symbol.X) scores[7]++;
            if (gameGrid[i][3].getOwner() == Symbol.O) scores[7]--;
        }


        return scores;
    }
    

    public void setFieldOwner(Symbol owner, int x, int y) {
        gameGrid[x][y].setOwner(owner);
    }

 
    public Symbol getFieldOwner(int x, int y) {
        return gameGrid[x][y].getOwner();
    }
    

    public void printField() {
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            for (int j = 0; j < BOARD_SIDE_LENGTH; j++) {
                System.out.print(gameGrid[i][j].getOwner() + " ");
            }
            System.out.println();
        }
    }
}
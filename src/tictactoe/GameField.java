package tictactoe;

import java.util.Arrays;

public class GameField {

    private final char[][] gameField = new char[3][3];
    private int countX = 0;
    private int countO = 0;



    public char[][] getGameField() {
        return gameField;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountO() {
        return countO;
    }

    public void getCountXandO() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == 'X') {
                    countX++;
                }
                if (gameField[i][j] == 'O') {
                    countO++;
                }
            }
        }
    }
    public void print() {
        System.out.println("---------");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == '_') {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void firstEnterCells(String cells) {
        int arrayCellsIndex = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = cells.charAt(arrayCellsIndex++);
            }
        }
    }
}

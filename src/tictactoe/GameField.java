package tictactoe;

import java.util.Arrays;

public class GameField {

    private char[][] gameField = new char[3][3];

    public GameField() {
        for (char[] chars : gameField) {
            Arrays.fill(chars, ' ');
        }
    }

    public void setGameField(char[][] gameField) {
        this.gameField = gameField;
    }

    public char[][] getGameField() {
        return gameField;
    }

    public void print() {
        System.out.println("---------");
        for (char[] chars : gameField) {
            System.out.print("| ");
            for (char aChar : chars) {
                if (aChar == '_') {
                    System.out.print("  ");
                    continue;
                }
                System.out.print(aChar + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void cleanField() {
        for (char[] chars : gameField) {
            Arrays.fill(chars, ' ');
        }
    }

}

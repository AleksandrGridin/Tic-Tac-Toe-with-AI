package tictactoe.players.algorithmsAI;

import tictactoe.GameField;

import java.util.*;

public class HardAlgorithm extends Algorithm {

    private char[][] currentTurn = new char[3][3];
    private int forX;
    private int forO;

    @Override
    public int[] getAlgorithm(char symbol) {

        init();
        gameField.setGameField(currentTurn);

        if (symbol == 'X') {
            forX = 10;
            forO = -10;
        } else {
            forO = 10;
            forX = -10;
        }

        int currentI = 0;
        int currentJ = 0;
        int currentScore = -10;

        for (int i = 0; i < gameField.getGameField().length; i++) {
            for (int j = 0; j < gameField.getGameField()[i].length; j++) {
                if (currentTurn[i][j] == ' ') {
                    currentTurn[i][j] = symbol;

                    int score = Math.min(getBestTurn(currentTurn, symbol),
                            getBestTurn(currentTurn, symbol));
                    currentTurn[i][j] = ' ';

                    if (currentScore < score) {
                        currentI = i;
                        currentJ = j;
                        currentScore = score;
                    }
                }
            }
        }

        return new int[] {currentI, currentJ};
    }

    private int getBestTurn(char[][] currentField, char player) {

        for (int i = 0; i < currentField.length; i++) {
            for (int j = 0; j < currentField[i].length; j++) {
                if (currentField[i][j] == ' ') {
                    currentField[i][j] = player;
                    if (checker.checkResult(currentField)) {
                        if (player == 'X') {
                            currentField[i][j] = ' ';
                            return forX;
                        }
                        if (player == 'O') {
                            currentField[i][j] = ' ';
                            return forO;
                        }
                    }
                    if (checkFreeCell(currentField)) {
                        getBestTurn(currentField, player == 'X' ? 'O' : 'X');
                        currentField[i][j] = ' ';
                    } else {
                        currentField[i][j] = ' ';
                        return 0;
                    }
                }
            }
        }
        return 0;
    }

    private boolean checkFreeCell(char[][] currentField) {
        for (int i = 0; i < gameField.getGameField().length; i++) {
            for (int j = 0; j < gameField.getGameField()[i].length; j++) {
                if (currentField[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private void init() {
        for (int i = 0; i < gameField.getGameField().length; i++) {
            for (int j = 0; j < gameField.getGameField()[i].length; j++) {
                currentTurn[i][j] = this.gameField.getGameField()[i][j];
            }
        }
    }
}

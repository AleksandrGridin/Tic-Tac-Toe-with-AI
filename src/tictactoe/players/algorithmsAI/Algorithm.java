package tictactoe.players.algorithmsAI;

import tictactoe.*;

import java.util.Random;

public abstract class Algorithm {

    protected Random random = new Random();
    protected Console console = Main.console;
    protected Checker checker = Game.checker;
    protected GameField gameField = Game.gameField;

    public abstract int[] getAlgorithm(char symbol);

    protected int[] getRandom() {
        int one = (random.nextInt(3) + 1) - 1;
        int two = (random.nextInt(3) + 1) - 1;
        return new int[] {one, two};
    }

    protected int[] checkIfStepCanWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField.getGameField()[i][j] == ' ') {
                    gameField.getGameField()[i][j] = symbol;
                    if (checker.checkResult()) {
                        gameField.getGameField()[i][j] = ' ';
                        return new int[]{i, j};
                    }
                    gameField.getGameField()[i][j] = ' ';
                }
            }
        }
        return null;
    }
}

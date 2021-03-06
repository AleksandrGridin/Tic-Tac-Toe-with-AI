package tictactoe.players;

import tictactoe.CheckerOfWin;
import tictactoe.GameField;

import java.util.Random;

public class PlayerAI extends Player {

    private Level level;
    private Random random = new Random();
    private char valueO;
    private GameField gameField;
    private CheckerOfWin checkerOfWin;

    public PlayerAI(Level level) {
        this.level = level;
    }

    public char getValue() {
        return valueO;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public void setCheckerOfWin(CheckerOfWin checkerOfWin) {
        this.checkerOfWin = checkerOfWin;
    }

    public void setValue(char valueO) {
        this.valueO = valueO;
    }

    public int[] doStep() {
        int one = (random.nextInt(3) + 1) - 1;
        int two = (random.nextInt(3) + 1) - 1;
        if (level.equals(Level.EASY)) {
            System.out.println("Making move level \"easy\"");
            return new int[] {one, two};
        } else if (level.equals(Level.MEDIUM)) {
            System.out.println("Making move level \"medium\"");
            int [] canWin = checkIfStepCanWin(valueO);
            char opponentChar = valueO == 'X' ? 'O' : 'X';
            int [] oppanentCanWin = checkIfStepCanWin(opponentChar);
            if (canWin != null) {
                return canWin;
            } else if (oppanentCanWin != null) {
                return oppanentCanWin;
            }
        }
        return new int[] {one, two};
    }
    private int[] checkIfStepCanWin(char value) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameField.getGameField()[i][j] == ' ') {
                    gameField.getGameField()[i][j] = value;
                    if (checkerOfWin.checkResult()) {
                        gameField.getGameField()[i][j] = ' ';
                        return new int[]{i, j};
                    } else {
                        gameField.getGameField()[i][j] = ' ';
                    }
                }
            }
        }
        return null;
    }
}

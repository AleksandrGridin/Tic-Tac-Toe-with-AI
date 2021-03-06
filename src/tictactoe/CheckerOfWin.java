package tictactoe;

public class CheckerOfWin {
    private GameField gameField;

    public CheckerOfWin(GameField gameField) {
        this.gameField = gameField;
    }
    public boolean checkResult() {
        return checkLinesHor() || checkLinesVer() || checkDiog();
    }

    private boolean checkLinesHor() {
        for (char[] chars : gameField.getGameField()) {
            String line = String.copyValueOf(chars);
            if (line.equals("XXX") || line.equals("OOO")) {
                //System.out.println(line.charAt(0) + " wins");
                return true;
            }
        }
        return false;
    }
    private boolean checkLinesVer() {

        char[] lineO = gameField.getGameField()[0];
        char[] line1 = gameField.getGameField()[1];
        char[] line2 = gameField.getGameField()[2];

        for (int i = 0; i < lineO.length; i++) {
            if (lineO[i] == ' ') {
                continue;
            }
            if (lineO[i] == line1[i]
                    && lineO[i] == line2[i]) {
                //System.out.println(lineO[i] + " wins");
                return true;
            }
        }
        return false;
    }

    private boolean checkDiog() {
        if (gameField.getGameField()[0][0]
                == gameField.getGameField()[1][1]
                && gameField.getGameField()[0][0]
                == gameField.getGameField()[2][2]) {
            if (gameField.getGameField()[0][0] != ' ') {
                //System.out.println(gameField.getGameField()[0][0] + " wins");
                return true;
            }
        }
        if (gameField.getGameField()[0][2]
                == gameField.getGameField()[1][1]
                && gameField.getGameField()[0][2]
                == gameField.getGameField()[2][0]) {
            if (gameField.getGameField()[0][2] != ' ') {
                //System.out.println(gameField.getGameField()[0][3] + " wins");
                return true;
            }
        }
        return false;
    }
}

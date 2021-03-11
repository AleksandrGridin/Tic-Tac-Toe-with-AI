package tictactoe.players.algorithmsAI;

public class MediumAlgorithm extends Algorithm {

    @Override
    public int[] getAlgorithm(char symbol) {
        console.writeMessage("Making move level \"medium\"");
        int[] giveTurn = checkIfStepCanWin(symbol);

        if (giveTurn == null) {
            char enemySymbol = symbol == 'X' ? 'O' : 'X';
            giveTurn = checkIfStepCanWin(enemySymbol);
        }
        return giveTurn != null ? giveTurn : getRandom() ;
    }

    public int[] checkIfStepCanWin(char symbol) {
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

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

}

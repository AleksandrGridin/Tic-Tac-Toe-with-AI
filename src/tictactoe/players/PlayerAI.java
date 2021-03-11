package tictactoe.players;


import tictactoe.Game;
import tictactoe.GameField;
import tictactoe.players.algorithmsAI.EasyAlgorithm;
import tictactoe.players.algorithmsAI.HardAlgorithm;
import tictactoe.players.algorithmsAI.MediumAlgorithm;

public class PlayerAI extends Player {

    public PlayerAI(Level level) {
        switch (level) {
            case EASY: algorithm = new EasyAlgorithm();
                break;
            case MEDIUM: algorithm = new MediumAlgorithm();
                break;
            case HARD: algorithm = new HardAlgorithm();
        }
    }

    public int[] doStep() {
        return algorithm.getAlgorithm(symbol);
    }
}

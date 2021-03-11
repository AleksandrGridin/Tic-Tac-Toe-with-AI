package tictactoe.players.algorithmsAI;

import tictactoe.*;

import java.util.Random;

public abstract class Algorithm {

    protected Random random = new Random();
    protected Console console = Main.console;
    protected Checker checker = Game.checker;
    protected GameField gameField = Game.gameField;

    public abstract int[] getAlgorithm(char symbol);

}

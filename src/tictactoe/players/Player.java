package tictactoe.players;

import tictactoe.Checker;
import tictactoe.Game;
import tictactoe.Main;
import tictactoe.players.algorithmsAI.Algorithm;

public abstract class Player {

    protected Checker checker = Game.checker;
    protected char symbol;
    protected Algorithm algorithm;


    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isWin() {
        if (checker.checkResult()) {
            Main.console.writeMessage(symbol + " wins");
            return true;
        }
        return false;
    }
    
    public abstract int[] doStep();

}

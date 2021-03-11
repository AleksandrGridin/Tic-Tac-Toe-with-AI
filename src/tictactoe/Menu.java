package tictactoe;

import tictactoe.exception.BadParameters;
import tictactoe.players.Level;
import tictactoe.players.Player;
import tictactoe.players.PlayerAI;
import tictactoe.players.PlayerHuman;

public class Menu {

    public Player getPlayer(String chosePlayer) throws BadParameters {
        switch (chosePlayer) {
            case "easy" : return new PlayerAI(Level.EASY);
            case "medium" : return new PlayerAI(Level.MEDIUM);
            case "hard" : return new PlayerAI(Level.HARD);
            case "user" : return new PlayerHuman();
            default : throw new BadParameters();
        }
    }

}

package tictactoe;

import tictactoe.players.Level;
import tictactoe.players.Player;
import tictactoe.players.PlayerAI;
import tictactoe.players.PlayerHuman;

public class Game {

    private GameField gameField;
    private final Console console;
    private CheckerOfWin checkerOfWin;
    private PlayerHuman playerHuman;
    private PlayerAI playerAI;
    private Player currentPlayer;


    public Game(GameField gameField, Console console) {
        this.gameField = gameField;
        this.console = console;
        checkerOfWin = new CheckerOfWin(gameField);
        playerHuman = new PlayerHuman(console);
        playerAI = new PlayerAI(Level.EASY);
    }

    public void startGame() {
        int i = 1;
        while (true) {
            try {
               currentPlayer = i % 2 == 0 ? playerAI : playerHuman;

               int[] getStepFromPlayer = currentPlayer.doStep();
               int one = getStepFromPlayer[0];
               int two = getStepFromPlayer[1];

               if (gameField.getGameField()[one][two] == ' ') {
                    gameField.getGameField()[one][two] = currentPlayer.getValue();
                    gameField.print();
                    if (checkerOfWin.checkResult()) {
                        break;
                    }
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                i++;
                if (i == 10) {
                    System.out.println("Draw");
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}

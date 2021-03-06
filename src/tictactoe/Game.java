package tictactoe;

import tictactoe.players.Level;
import tictactoe.players.Player;
import tictactoe.players.PlayerAI;
import tictactoe.players.PlayerHuman;

public class Game {

    private GameField gameField = new GameField();
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    private final Console console;
    private CheckerOfWin checkerOfWin;



    public Game(Console console, Player playerOne, Player playerTwo) {
        this.console = console;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        checkerOfWin = new CheckerOfWin(gameField);
    }

    public void startGame() {
        if (playerOne instanceof PlayerAI) {
            ((PlayerAI) playerOne).setGameField(gameField);
            ((PlayerAI) playerOne).setCheckerOfWin(checkerOfWin);
        }
        if (playerTwo instanceof PlayerAI) {
            ((PlayerAI) playerTwo).setCheckerOfWin(checkerOfWin);
            ((PlayerAI) playerTwo).setGameField(gameField);
        }
        int i = 1;
        while (true) {
            try {
               currentPlayer = i % 2 == 0 ? playerTwo : playerOne;

               int[] getStepFromPlayer = currentPlayer.doStep();
               int one = getStepFromPlayer[0];
               int two = getStepFromPlayer[1];


               if (gameField.getGameField()[one][two] == ' ') {
                    gameField.getGameField()[one][two] = currentPlayer.getValue();
                    gameField.print();
                    if (checkerOfWin.checkResult()) {
                        System.out.println(currentPlayer.getValue() + " wins");
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

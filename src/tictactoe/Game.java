package tictactoe;

import tictactoe.exception.CellOccupied;
import tictactoe.players.Player;

public class Game {

    public static final GameField gameField = new GameField();
    public static final Checker checker = new Checker(gameField);

    private final Player playerOne;
    private final Player playerTwo;
    private final Console console = Main.console;


    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        initPlayers();
    }

    private void initPlayers() {
        playerOne.setSymbol('X');
        playerTwo.setSymbol('O');
        gameField.print();
    }

    public void startGame() {
        int currentStepOfTheGame = 1;
        while (true) {

            try {
                Player currentPlayer = currentStepOfTheGame % 2 == 0 ? playerTwo : playerOne;

                int[] getStepFromPlayer = currentPlayer.doStep();
                int one = getStepFromPlayer[0];
                int two = getStepFromPlayer[1];

                checkTurn(currentPlayer, one, two);
                gameField.print();
                if (currentPlayer.isWin()) {
                    gameField.cleanField();
                    break;
                }
                currentStepOfTheGame++;
                if (isDraw(currentStepOfTheGame)) {
                    gameField.cleanField();
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                console.writeMessage("Coordinates should be from 1 to 3!");
            } catch (NumberFormatException e) {
                console.writeMessage("You should enter numbers!");
            } catch (CellOccupied cellOccupied) {
                console.writeMessage("This cell is occupied! Choose another one!");
            }
        }
    }

    private void checkTurn(Player currentPlayer, int one, int two) throws CellOccupied {
        if (gameField.getGameField()[one][two] == ' ') {
            gameField.getGameField()[one][two] = currentPlayer.getSymbol();
        } else {
            throw new CellOccupied();
        }
    }

    private boolean isDraw(int currentStepOfTheGame) {
        if (currentStepOfTheGame == 10) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

}

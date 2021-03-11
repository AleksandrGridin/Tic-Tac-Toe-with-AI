package tictactoe;

import tictactoe.exception.BadParameters;
import tictactoe.players.Player;

public class Main {

    public static Console console = new Console();

    public static void main(String[] args) {

        while (true) {
            try {
                console.writeMessage("Input command: ");
                String[] line = console.readFromConsole().split(" ");
                String startOrExitGame = line[0];
                if (startOrExitGame.equals("exit")) {
                    break;
                }
                String chosePlayerOne = line[1];
                String chosePlayerTwo = line[2];

                Menu menu = new Menu();
                Player playerOne = menu.getPlayer(chosePlayerOne);
                Player playerTwo = menu.getPlayer(chosePlayerTwo);

                if (startOrExitGame.equals("start")) {
                    Game game = new Game(playerOne, playerTwo);
                    game.startGame();
                }
            } catch (IndexOutOfBoundsException | BadParameters e) {
                console.writeMessage("Bad parameters!");
            }
        }
    }
}
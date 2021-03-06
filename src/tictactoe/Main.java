package tictactoe;

import tictactoe.players.Level;
import tictactoe.players.Player;
import tictactoe.players.PlayerAI;
import tictactoe.players.PlayerHuman;

public class Main {
    public static void main(String[] args) {

        Console console = new Console();

        while (true) {
            System.out.print("Input command: ");
            String[] line = console.readFromConsole().split(" ");
            Player playerOne = null;
            Player playerTwo = null;
            try {
                if (line[0].equals("start")) {
                    if (line[1].equals("easy")) {
                        playerOne = new PlayerAI(Level.EASY);
                    } else if (line[1].equals("user")) {
                        playerOne = new PlayerHuman(console);
                    } else if (line[1].equals("medium")) {
                        playerOne = new PlayerAI(Level.MEDIUM);
                    } else {
                        System.out.println("Bad parameters!");
                        continue;
                    }
                    if (line[2].equals("easy")) {
                        playerTwo = new PlayerAI(Level.EASY);
                    } else if (line[2].equals("user")) {
                        playerTwo = new PlayerHuman(console);
                    } else if (line[2].equals("medium")) {
                        playerTwo = new PlayerAI(Level.MEDIUM);
                    } else {
                        System.out.println("Bad parameters!");
                        continue;
                    }
                } else if (line[0].equals("exit")) {
                    break;
                } else {
                    System.out.println("Bad parameters!");
                    continue;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Bad parameters!");
                continue;
            }
            playerOne.setValue('X');
            playerTwo.setValue('O');
            Game game = new Game(console, playerOne, playerTwo);
            game.startGame();
        }

    }
}

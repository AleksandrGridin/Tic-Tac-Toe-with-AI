package tictactoe.players;

import tictactoe.Console;
import tictactoe.Main;

public class PlayerHuman extends Player {

    Console console = Main.console;

    public int[] doStep() {
        System.out.print("Enter the coordinates: ");
        String[] step = console.readFromConsole().trim().split(" ");
        int one = Integer.parseInt(step[0]) - 1;
        int two = Integer.parseInt(step[1]) - 1;
        return new int[]{one, two};
    }
}

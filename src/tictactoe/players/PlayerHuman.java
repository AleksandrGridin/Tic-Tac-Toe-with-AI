package tictactoe.players;

import tictactoe.Console;

public class PlayerHuman extends Player {

    Console console;
    private char valueX;

    public PlayerHuman(Console console) {
        this.console = console;
    }

    public char getValue() {
        return valueX;
    }

    public void setValue(char valueX) {
        this.valueX = valueX;
    }

    public int[] doStep() {
        System.out.print("Enter the coordinates: ");
        String[] step = console.readFromConsole().trim().split(" ");
        int one = Integer.parseInt(step[0]) - 1;
        int two = Integer.parseInt(step[1]) - 1;
        return new int[]{one, two};
    }
}

package tictactoe.players;

import java.util.Random;

public class PlayerAI extends Player {

    private Level level;
    private Random random = new Random();
    private char valueO = 'O';

    public PlayerAI(Level level) {
        this.level = level;
    }

    public char getValue() {
        return valueO;
    }

    public int[] doStep() {
        System.out.println("Making move level \"easy\"");
        int one = random.nextInt(3);
        int two = random.nextInt(3);
        return new int[] {one, two};
    }

}

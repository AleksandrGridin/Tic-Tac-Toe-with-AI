package tictactoe.players.algorithmsAI;

public class EasyAlgorithm extends Algorithm {

    @Override
    public int[] getAlgorithm(char symbol) {
        int one = (random.nextInt(3) + 1) - 1;
        int two = (random.nextInt(3) + 1) - 1;
        console.writeMessage("Making move level \"easy\"");
        return new int[] {one, two};
    }
}

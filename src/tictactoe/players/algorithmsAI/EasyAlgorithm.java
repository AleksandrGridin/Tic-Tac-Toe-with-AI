package tictactoe.players.algorithmsAI;

public class EasyAlgorithm extends Algorithm {

    @Override
    public int[] getAlgorithm(char symbol) {
        console.writeMessage("Making move level \"easy\"");
        return getRandom();
    }
}

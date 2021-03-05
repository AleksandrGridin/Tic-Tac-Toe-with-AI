package tictactoe.players;

public abstract class Player {

    public abstract char getValue();
    public abstract int[] doStep();
    public abstract void setValue(char ch);
}

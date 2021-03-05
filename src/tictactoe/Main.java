package tictactoe;

public class Main {
    public static void main(String[] args) {
        GameField gameField = new GameField();
        Console console = new Console();
        Game game = new Game(gameField, console);
        System.out.print("Enter the cells: ");
        gameField.firstEnterCells(console.readFromConsole());
        gameField.print();
        game.doStep();

    }
}

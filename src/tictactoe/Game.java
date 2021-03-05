package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final GameField gameField;
    private final Console console;
    private boolean isWin = false;

    public Game(GameField gameField, Console console) {
        this.gameField = gameField;
        this.console = console;
    }

    public void doStep() {

        while (true) {
            System.out.print("Enter the coordinates: ");
            String[] line = console.readFromConsole().split(" ");
            try {
                int one = Integer.parseInt(line[0]) - 1;
                int two = Integer.parseInt(line[1]) - 1;

                if (gameField.getGameField()[one][two] == '_') {
                    gameField.getCountXandO();
                    gameField.getGameField()[one][two] =
                            gameField.getCountX() == gameField.getCountO() ? 'X' : 'O';

                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                gameField.print();
                if (checkResult(gameField.getGameField())) {

                } else {
                    System.out.println("Game not finished");
                }
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
    //TODO change it
    private static boolean checkResult(char[][] grid) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(grid[0][0]) + grid[0][1] + grid[0][2]);
        list.add(String.valueOf(grid[1][0]) + grid[1][1] + grid[1][2]);
        list.add(String.valueOf(grid[2][0]) + grid[2][1] + grid[2][2]);
        list.add(String.valueOf(grid[0][0]) + grid[1][0] + grid[2][0]);
        list.add(String.valueOf(grid[0][1]) + grid[1][1] + grid[2][1]);
        list.add(String.valueOf(grid[0][2]) + grid[1][2] + grid[2][2]);
        list.add(String.valueOf(grid[0][0]) + grid[1][1] + grid[2][2]);
        list.add(String.valueOf(grid[0][2]) + grid[1][1] + grid[2][0]);

        String result = "";
        boolean truResult = false;
        for (String r : list) {
            if (r.equals("XXX") || r.equals("OOO")) {
                result = r;
                truResult = true;
                System.out.println(result.charAt(0) +" wins");
            }
        }
        return truResult;
    }

}

package tictactoe;

import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);

    public String readFromConsole() {
        return scanner.nextLine();
    }
}

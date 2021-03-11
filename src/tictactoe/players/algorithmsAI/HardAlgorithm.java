package tictactoe.players.algorithmsAI;

import java.util.Comparator;

public class HardAlgorithm extends Algorithm {

    private char[][] currentField = new char[3][3];

    @Override
    public int[] getAlgorithm(char player) {

        init();
        console.writeMessage("Making move level \"hard\"");

        int[] giveTurn = checkIfStepCanWin(player);

        if (giveTurn == null) {
            char enemySymbol = player == 'X' ? 'O' : 'X';
            giveTurn = checkIfStepCanWin(enemySymbol);
        }
        if (giveTurn != null) {
            return giveTurn;
        }
        // root Node
        Node node = new Node();
        mainLoop(currentField, node, player, 1);

        return node.getNodeList()
                .stream()
                .max(Comparator.comparing(Node::getScore))
                .get()
                .getCoordinate();

    }

    private void mainLoop(char[][] currentField, Node node, char playerTwo, int level) {
        for (int i = 0; i < currentField.length; i++) {
            for (int j = 0; j < currentField[i].length; j++) {
                if (currentField[i][j] == ' ') {
                    currentField[i][j] = playerTwo;
                    Node child = new Node(new int[] {i,j});
                    node.getNodeList().add(child);
                    if (checker.checkResult(currentField)) {
                        child.setScore(10);
                        currentField[i][j] = ' ';
                        break;

                    }
                    if (!isFreeCells(currentField)) {
                        child.setScore(0);
                        currentField[i][j] = ' ';
                        break;
                    } else {
                        childLoop(currentField, child, playerTwo == 'X' ? 'O' : 'X', level++);
                    }
                    currentField[i][j] = ' ';
                }
            }
        }
    }

    private void childLoop(char[][] currentField, Node node, char playerOne, int level) {
        for (int i = 0; i < currentField.length; i++) {
            for (int j = 0; j < currentField[i].length; j++) {
                if (currentField[i][j] == ' ') {
                    currentField[i][j] = playerOne;
                    Node child = new Node(new int[] {i,j});
                    node.getNodeList().add(child);
                    if (checker.checkResult(currentField)) {
                        child.setScore(-10);
                        currentField[i][j] = ' ';
                        break;
                    }
                    if (!isFreeCells(currentField)) {
                        child.setScore(0);
                        currentField[i][j] = ' ';
                        break;
                    } else {
                        mainLoop(currentField, child, playerOne == 'X' ? 'O' : 'X', level++);
                    }
                    currentField[i][j] = ' ';
                }
            }
        }
    }

    private void init() {
        for (int i = 0; i < gameField.getGameField().length; i++) {
            for (int j = 0; j < gameField.getGameField()[i].length; j++) {
                currentField[i][j] = this.gameField.getGameField()[i][j];
            }
        }
    }

    private boolean isFreeCells(char[][] currentField) {
        for (int i = 0; i < currentField.length; i++) {
            for (int j = 0; j < currentField[i].length; j++) {
                if (currentField[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }


}

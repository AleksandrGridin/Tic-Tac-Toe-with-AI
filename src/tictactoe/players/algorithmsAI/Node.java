package tictactoe.players.algorithmsAI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Node {

    private int[] coordinate;
    private List<Node> nodeList = new ArrayList<>();
    private int score;


    public Node() {
    }

    public Node(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public int getScore() {
        if (nodeList.isEmpty()) {
            return score;
        }
        return nodeList.stream()
                .mapToInt(Node::getScore).sum();
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

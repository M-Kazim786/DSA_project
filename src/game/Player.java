package game;

import java.util.Stack;

public class Player {
    private AdventureNode currentNode;
    private Stack<AdventureNode> path;

    public Player(AdventureNode startNode) {
        this.currentNode = startNode;
        this.path = new Stack<>();
    }

    public AdventureNode getCurrentNode() {
        return currentNode;
    }

    public void moveTo(AdventureNode nextNode) {
        path.push(currentNode);
        currentNode = nextNode;
    }

    public boolean canGoBack() {
        return !path.isEmpty();
    }

    public void goBack() {
        if (canGoBack()) {
            currentNode = path.pop();
        }
    }
}
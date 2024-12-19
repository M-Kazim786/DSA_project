package game;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class GameEngine {
    private AdventureNode currentNode;
    private AdventureNode startNode; // Keep track of the starting node
    private Scanner scanner;
    private Stack<AdventureNode> history;

    public GameEngine(AdventureNode startNode) {
        this.currentNode = startNode;
        this.startNode = startNode; // Save the start node for resetting the game
        this.scanner = new Scanner(System.in);
        this.history = new Stack<>();
    }

    public void startGame() {
        System.out.println("Welcome to 'The Chronicles of Eldoria'!");
        while (true) {
            displayCurrentNode();

            if (currentNode.isEndNode()) {
                System.out.println("The adventure has ended.");
                if (askToReplay()) break;
                else resetGame();
                continue;
            }

            handleUserInput();
        }

        System.out.println("\nThank you for playing 'The Chronicles of Eldoria'!");
    }

    private void displayCurrentNode() {
        System.out.println("\n" + currentNode.getDescription());
        List<AdventureNode> choices = currentNode.getChoices();

        if (!choices.isEmpty()) {
            if (choices.size() == 1) {
                System.out.print("Type 'C' to continue or 'B' to go back: ");
            } else {
                System.out.println("\nWhat would you like to do?");
                for (int i = 0; i < choices.size(); i++) {
                    System.out.println((i + 1) + ". " + choices.get(i).getDescription());
                }
                System.out.print("Enter your choice (or type 'B' to go back): ");
            }
        }
    }

    private boolean askToReplay() {
        System.out.print("\nWould you like to replay the game? (Y/N): ");
        String input = scanner.nextLine().trim().toUpperCase();
        return input.equals("N");
    }

    private void resetGame() {
        history.clear(); // Clear the history stack
        currentNode = startNode; // Reset to the starting node
    }

    private void handleUserInput() {
        String input = scanner.nextLine().trim().toUpperCase();

        if (input.equals("B")) {
            handleBacktracking();
        } else if (input.equals("C") && currentNode.getChoices().size() == 1) {
            handleContinue();
        } else {
            try {
                int choice = Integer.parseInt(input) - 1;
                handleChoiceSelection(choice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number, 'B' to go back, or 'C' to continue.");
            }
        }
    }

    private void handleBacktracking() {
        if (!history.isEmpty()) {
            currentNode = history.pop();
        } else {
            System.out.println("You cannot go back any further!");
        }
    }

    private void handleChoiceSelection(int choice) {
        List<AdventureNode> choices = currentNode.getChoices();

        if (choice >= 0 && choice < choices.size()) {
            history.push(currentNode);
            currentNode = choices.get(choice); // Directly navigate to the chosen node
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }

    private void handleContinue() {
        currentNode = currentNode.getChoices().get(0);
    }
}

package game;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class GameEngine {
    private AdventureNode currentNode;
    private Scanner scanner;
    private Stack<AdventureNode> history;

    public GameEngine(AdventureNode startNode) {
        this.currentNode = startNode;
        this.scanner = new Scanner(System.in);
        this.history = new Stack<>();
    }

    public void startGame() {
        System.out.println("Welcome to 'The Chronicles of Eldoria'!");
        while (true) {
            System.out.println("\n" + currentNode.getDescription());

            List<AdventureNode> choices = currentNode.getChoices();
            if (choices.isEmpty()) {
                System.out.println("The adventure has ended.");
                break;
            }

            System.out.println("\nWhat would you like to do?");
            for (int i = 0; i < choices.size(); i++) {
                System.out.println((i + 1) + ". " + choices.get(i).getDescription());
            }
            System.out.print("Enter your choice (or type 'B' to go back): ");

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("B")) {
                if (!history.isEmpty()) {
                    currentNode = history.pop();
                } else {
                    System.out.println("You cannot go back any further!");
                }
            } else {
                try {
                    int choice = Integer.parseInt(input) - 1;
                    if (choice >= 0 && choice < choices.size()) {
                        history.push(currentNode);
                        currentNode = choices.get(choice).getChoices().get(0);
                    } else {
                        System.out.println("Invalid choice. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a number or type 'B' to go back.");
                }
            }
        }

        System.out.println("\nThank you for playing 'The Chronicles of Eldoria'!");
    }
}

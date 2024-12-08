package game;

import java.util.ArrayList;
import java.util.List;

public class AdventureNode {
    private String description;
    private List<AdventureNode> choices;

    public AdventureNode(String description) {
        this.description = description;
        this.choices = new ArrayList<>();
    }

    public void addChoice(String choiceDescription, AdventureNode destination) {
        AdventureNode choice = new AdventureNode(choiceDescription);
        choice.choices.add(destination);
        this.choices.add(choice);
    }

    public String getDescription() {
        return description;
    }

    public List<AdventureNode> getChoices() {
        return choices;
    }

    public boolean isEndNode() {
        return choices.isEmpty();
    }
}
package game;

public class AdventureGame {

	public static void main(String[] args) {
		StoryTree storyTree = new StoryTree();
		AdventureNode startNode = storyTree.buildStory();

		GameEngine gameEngine = new GameEngine(startNode);
		gameEngine.startGame();

	}
}
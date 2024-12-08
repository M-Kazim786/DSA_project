package game;

public class StoryTree {
    public AdventureNode buildStory() {
        AdventureNode start = new AdventureNode("🌳 You stand at the edge of a mystical forest. An eerie mist swirls around your feet, and the trees seem to whisper ancient secrets. Do you dare to enter?");
        AdventureNode forestPath = new AdventureNode("🍃 Stepping into the forest, you're enveloped by a canopy that barely allows sunlight through. Ahead, you see two paths: one well-trodden, the other overgrown and ominous.");
        AdventureNode markedPath = new AdventureNode("🌿 Following the well-trodden path, you emerge into a serene clearing. A babbling stream 💧 catches your attention, but so does a fork in the path ahead.");
        AdventureNode wildTrail = new AdventureNode("🌚 The overgrown path leads you deeper into the wild. Shadows dance at the edge of your vision, and strange sounds echo in the distance.");
        AdventureNode cabin = new AdventureNode("🏚️ Through the trees, you spot a weathered cabin. Its windows are dark, but the door stands slightly ajar, as if inviting you in.");
        AdventureNode deeperForest = new AdventureNode("🌲 Venturing deeper, the forest grows denser. The air becomes thick with an otherworldly presence, and you feel watched by unseen eyes 👀.");
        AdventureNode cave = new AdventureNode("🕳️ A yawning cave mouth looms before you, its depths shrouded in mystery. A chill wind emanates from within, carrying whispers of both danger and promise.");
        AdventureNode mysteriousTunnel1 = new AdventureNode("🕯️ This passage seems to absorb all light, yet you sense something stirring in its depths.");
        AdventureNode mysteriousTunnel2 = new AdventureNode("✨ The tunnel beckons with an otherworldly aura. What secrets might it hold?");
        AdventureNode ancientTree = new AdventureNode("🌳 Before you stands an ancient tree, its bark etched with cryptic symbols. As you approach, a faint glow pulses from within its gnarled trunk.");
        AdventureNode hiddenPath = new AdventureNode("🌿 You discover a hidden path, barely visible amidst the undergrowth. It seems to lead to a place untouched by time ⏳.");
        AdventureNode narrowPath = new AdventureNode("🐾 The narrow path winds around the ancient tree, its destination uncertain.");

        start.addChoice("Step into the unknown 🚶", forestPath);
        start.addChoice("Remain in the familiar world 🏡", new AdventureNode("You decide not to enter the forest, the call of adventure left unanswered. The story ends here, but what mysteries remain undiscovered? 🤔"));

        forestPath.addChoice("Follow the well-trodden path 👣", markedPath);
        forestPath.addChoice("Brave the overgrown trail 🌿", wildTrail);

        markedPath.addChoice("Investigate the cabin 🏚️", cabin);
        markedPath.addChoice("Press on into the depths 🌲", deeperForest);

        wildTrail.addChoice("Explore the mysterious cave 🕳️", cave);
        wildTrail.addChoice("Attempt to retrace your steps 🔙", start);

        cabin.addChoice("Enter the cabin 🚪", new AdventureNode("With trepidation, you push open the creaking door. The cabin's interior holds secrets of its own, forever changing your path. 🔮"));
        cabin.addChoice("Return to the clearing 🌿", markedPath);

        deeperForest.addChoice("Approach the ancient tree 🌳", ancientTree);
        deeperForest.addChoice("Try to find your way back 🧭", new AdventureNode("The forest seems to shift around you, paths disappearing as quickly as they appear. You realize, with growing dread, that you're hopelessly lost. 😱"));

        cave.addChoice("Enter the shimmering tunnel ✨", mysteriousTunnel2);
        cave.addChoice("Venture into the shadowy passage 🕯️", mysteriousTunnel1);

        mysteriousTunnel1.addChoice("Continue deeper 🚶‍♂️", new AdventureNode("The tunnel opens into a vast, dark chamber, glittering with untold treasures. You’ve uncovered the legendary hoard of Eldoria, hidden away in the shadows. It was a perilous journey, but the riches you’ve found make every step in the darkness worthwhile. 💎✨"));

        mysteriousTunnel2.addChoice("Press on 🏃‍♂️", new AdventureNode("As you step into the shimmering light, the air hums with energy. The treasure you seek eludes you, slipping through your grasp like a fleeting dream. The legends remain hidden, and you are left with only echoes of what could have been. 💫"));

        ancientTree.addChoice("Investigate the hidden path 🕵️", hiddenPath);
        ancientTree.addChoice("Follow the winding trail 🐾", narrowPath);

        hiddenPath.addChoice("Descend into the unknown 🕳️", new AdventureNode("The hidden path leads to a chamber pulsing with primordial energy. As you grasp an artifact of immense power, you realize you've uncovered the heart of Eldoria's magic. Your destiny is forever altered. ⚡🔮"));

        narrowPath.addChoice("Continue along the path 🚶‍♂️", new AdventureNode("The path brings you full circle, back to the forest's edge. You emerge changed, carrying the weight of unspoken mysteries. The adventure ends, but the forest's secrets will forever haunt your dreams. 🌙💭"));

        return start;
    }
}


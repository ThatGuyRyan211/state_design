package state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Represents a grade level in the vocabulary game. Each concrete state loads
 * its own vocabulary file and controls how the grade can change.
 */
public abstract class State {
    /** The game object whose current grade state is being managed. */
    protected VocabularyList vocabularyList;

    /** Maps each definition to its matching vocabulary word. */
    protected HashMap<String, String> words;

    /** Selects a random definition for a vocabulary round. */
    protected Random rand;

    /**
     * Creates a state for the supplied vocabulary game.
     *
     * @param vocabularyList the vocabulary game that owns this state
     */
    public State(VocabularyList vocabularyList) {
        this.vocabularyList = vocabularyList;
        words = new HashMap<String, String>();
        rand = new Random();
    }

    /**
     * Returns a randomly selected definition from this grade's vocabulary.
     *
     * @return a vocabulary definition, or an empty string if no words exist
     */
    public String getNextDefinition() {
        if (words.isEmpty()) {
            return "";
        }

        List<String> definitions = new ArrayList<String>(words.keySet());
        return definitions.get(rand.nextInt(definitions.size()));
    }

    /**
     * Finds the word that matches a definition.
     *
     * @param definition the definition shown to the player
     * @return the matching vocabulary word, or an empty string when absent
     */
    public String getMatchingWord(String definition) {
        String word = words.get(definition);
        return word == null ? "" : word;
    }

    /** Moves the game up one grade level when that is possible. */
    public abstract void increaseGrade();

    /** Moves the game down one grade level when that is possible. */
    public abstract void decreaseGrade();
}

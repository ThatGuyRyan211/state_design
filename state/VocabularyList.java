/**
 * Stores all grade states and delegates vocabulary actions to the current
 * state. This is the context class in the State design pattern.
 */
public class VocabularyList {
    /** The grade level currently selected by the player. */
    private State state;

    /** Cached first-grade state. */
    private State firstGradeState;

    /** Cached second-grade state. */
    private State secondGradeState;

    /** Cached third-grade state. */
    private State thirdGradeState;

    /** Creates the game and begins at the first-grade vocabulary level. */
    public VocabularyList() {
        firstGradeState = new FirstGradeState(this);
        secondGradeState = new SecondGradeState(this);
        thirdGradeState = new ThirdGradeState(this);
        state = firstGradeState;
    }

    /**
     * Gets a random definition from the current grade level.
     *
     * @return a definition from the current grade's vocabulary
     */
    public String getNextDefinition() {
        return state.getNextDefinition();
    }

    /**
     * Gets the word matching a definition in the current grade level.
     *
     * @param definition the definition displayed to the player
     * @return the vocabulary word that matches the definition
     */
    public String getMatchingWord(String definition) {
        return state.getMatchingWord(definition);
    }

    /** Requests a change to the next higher grade level. */
    public void increaseGrade() {
        state.increaseGrade();
    }

    /** Requests a change to the next lower grade level. */
    public void decreaseGrade() {
        state.decreaseGrade();
    }

    /**
     * Returns the first-grade state.
     *
     * @return the first-grade state
     */
    public State getFirstGradeState() {
        return firstGradeState;
    }

    /**
     * Returns the second-grade state.
     *
     * @return the second-grade state
     */
    public State getSecondGradeState() {
        return secondGradeState;
    }

    /**
     * Returns the third-grade state.
     *
     * @return the third-grade state
     */
    public State getThirdGradeState() {
        return thirdGradeState;
    }

    /**
     * Sets the game's current grade state.
     *
     * @param state the new current grade state
     */
    public void setState(State state) {
        this.state = state;
    }
}

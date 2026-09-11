package state;

/** Represents the first-grade vocabulary level. */
public class FirstGradeState extends State {
    /**
     * Creates the first-grade state and loads the first-grade vocabulary.
     *
     * @param vocabularyList the vocabulary game that owns this state
     */
    public FirstGradeState(VocabularyList vocabularyList) {
        super(vocabularyList);
        words = FileReader.getWords("state/txt/first.txt");
    }

    /** Changes the game to the second-grade vocabulary level. */
    @Override
    public void increaseGrade() {
        System.out.println("Moving to Second Grade...");
        vocabularyList.setState(vocabularyList.getSecondGradeState());
    }

    /** Explains that first grade is already the lowest available level. */
    @Override
    public void decreaseGrade() {
        System.out.println("You are already in First Grade.");
    }
}

/** Represents the third-grade vocabulary level. */
public class ThirdGradeState extends State {
    /**
     * Creates the third-grade state and loads the third-grade vocabulary.
     *
     * @param vocabularyList the vocabulary game that owns this state
     */
    public ThirdGradeState(VocabularyList vocabularyList) {
        super(vocabularyList);
        words = FileReader.getWords("state/txt/third.txt");
    }

    /** Explains that third grade is already the highest available level. */
    @Override
    public void increaseGrade() {
        System.out.println("You are already in Third Grade.");
    }

    /** Changes the game to the second-grade vocabulary level. */
    @Override
    public void decreaseGrade() {
        System.out.println("Moving to Second Grade...");
        vocabularyList.setState(vocabularyList.getSecondGradeState());
    }
}

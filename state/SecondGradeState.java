/** Represents the second-grade vocabulary level. */
public class SecondGradeState extends State {
    /**
     * Creates the second-grade state and loads the second-grade vocabulary.
     *
     * @param vocabularyList the vocabulary game that owns this state
     */
    public SecondGradeState(VocabularyList vocabularyList) {
        super(vocabularyList);
        words = FileReader.getWords("state/txt/second.txt");
    }

    /** Changes the game to the third-grade vocabulary level. */
    @Override
    public void increaseGrade() {
        System.out.println("Moving to Third Grade...");
        vocabularyList.setState(vocabularyList.getThirdGradeState());
    }

    /** Changes the game to the first-grade vocabulary level. */
    @Override
    public void decreaseGrade() {
        System.out.println("Moving to First Grade...");
        vocabularyList.setState(vocabularyList.getFirstGradeState());
    }
}

package state;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WordGameDriver {
    private static final int NUM_WORDS = 5;
    private Scanner reader;
    private VocabularyList vocabularyList;
    private static final String[] mainOptions = { "Show Round of Questions", "Increase Grade", "Decrease Grade", "Quit" };

    public WordGameDriver() {
        reader = new Scanner(System.in);
        vocabularyList = new VocabularyList();
    }

    public void run() {
        clear();
        System.out.println("Welcome to our Vocabulary Game");
        System.out.println("We will show you a definition, and then the corresponding word.");
        System.out.println("Currently you are in first grade.\n");

        while (true) {
            int option = getUserOption();
            clear();

            if (option == 1) {
                showVocabRound();
            } else if (option == 2) {
                vocabularyList.increaseGrade();
            } else if (option == 3) {
                vocabularyList.decreaseGrade();
            } else if (option == 4) {
                System.out.println("Goodbye");
                break;
            } else {
                System.out.println("Sorry Invalid command");
            }
        }
    }

    private void showVocabRound() {
        for (int i = 0; i < NUM_WORDS; i++) {
            String definition = vocabularyList.getNextDefinition();
            System.out.println(definition);
            timeout(3000);
            System.out.println(vocabularyList.getMatchingWord(definition));
            timeout(1000);
            clear();
        }
    }

    private int getUserOption() {
        for (int i = 0; i < mainOptions.length; i++) {
            System.out.println((i + 1) + ". " + mainOptions[i]);
        }
        return Integer.parseInt(reader.nextLine());
    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void timeout(int time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }

    public static void main(String[] args) {
        WordGameDriver driver = new WordGameDriver();
        driver.run();
    }
}

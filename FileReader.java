package state;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    public static HashMap<String, String> getWords(String fileName) {
        HashMap<String, String> words = new HashMap<String, String>();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] sections = line.split("\\|");
                String definition = sections[0].trim();
                String word = sections[1].trim();
                words.put(definition, word);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        return words;
    }
}

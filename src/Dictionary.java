import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        List <DictionaryEntry> allWords = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("dictionary.txt"))){
            boolean isNextWord = true;
            String word = "";
            String description = "";
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (isNextWord) {
                    word = line;
                    isNextWord = false;
                    continue;
                }
                if (line.startsWith("===")) {
                    allWords.add(new DictionaryEntry(word, description));
                    word = "";
                    description = "";
                    isNextWord = true;
                    continue;


                }
                description += line + " ";

            }
        } catch (FileNotFoundException e) {
            System.out.println("Проблема при чтении файла dictionary");
            System.exit(0);
        }

        try(Scanner scanner = new Scanner(new File("query.txt"))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (DictionaryEntry dictionaryEntry : allWords) {
                    String word = dictionaryEntry.getWord();
                    if (word.toLowerCase().contains(line.toLowerCase())) {
                        System.out.print(word + ": " + dictionaryEntry.getDescription() + "\n");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Проблема при чтении файла query");
            System.exit(0);
        }
    }
}

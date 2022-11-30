import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ListOfWords {

    private final ArrayList<String> words;
    private final Random random = new Random();

    private ListOfWords(ArrayList<String> words) {
        this.words = words;
    }

    public static ListOfWords ListOfWordsFactory() throws FileNotFoundException {
        ArrayList<String> arraylist = new ArrayList<>();
        FileInputStream file = new FileInputStream("liste_mot_francais.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            arraylist.add(line);
        }
        scanner.close();
        return new ListOfWords(arraylist);
    }

    public ArrayList<String> randomSelect(int nbElements) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < nbElements; i++) {
            int randomIndex = random.nextInt(words.size());
            result.add(words.get(randomIndex));
        }
        return result;
    }

    public ArrayList<String> find(ArrayList<String> l) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : l) {
            if (words.contains(word)) {
                result.add(word + " yes");
            } else {
                result.add(word + " no");
            }
        }
        return result;
    }
}

import java.io.FileInputStream;
import java.util.*;

public class HashOfWords {

    private final Map<Integer, String> map;

    private HashOfWords(Map<Integer, String> words) {
        this.map = words;
    }

    public static HashOfWords HashOfWordsFactory(int i) throws Exception {
        Map<Integer, String> map;
        switch (i) {
            case 0:
                map = new HashMap<>();
                break;
            case 1:
                map = new TreeMap<>();
                break;
            case 2:
                map = new LinkedHashMap<>();
                break;
            default:
                throw new Exception("le paramètre ne peut être que 0, 1, 2");
        }
        FileInputStream file = new FileInputStream("liste_mot_francais.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            map.put(line.hashCode(), line);
        }
        scanner.close();
        return new HashOfWords(map);
    }

    public ArrayList<String> findValuesList(ArrayList<String> l) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : l) {
            if (this.map.containsValue(word)) {
                result.add(word + " yes");
            } else {
                result.add(word + " no");
            }
        }
        return result;
    }

    public ArrayList<String> findValuesToSet(ArrayList<String> l) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> hashset = new HashSet<>(this.map.values());
        for (String word : l) {
            if (hashset.contains(word)) {
                result.add(word + " yes");
            } else {
                result.add(word + " no");
            }
        }
        return result;
    }

    public ArrayList<String> findKeys(ArrayList<String> l) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : l) {
            if (this.map.containsKey(word.hashCode())) {
                result.add(word + " yes");
            } else {
                result.add(word + " no");
            }
        }
        return result;
    }
}
